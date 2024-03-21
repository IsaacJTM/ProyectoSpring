package com.proyecto.listaPendientes.infrastructure.adapter;

import com.proyecto.listaPendientes.domain.aggregates.constants.Constants;
import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
import com.proyecto.listaPendientes.domain.aggregates.request.SignInRequest;
import com.proyecto.listaPendientes.domain.aggregates.request.SignUpRequest;
import com.proyecto.listaPendientes.domain.aggregates.response.AuthenticationResponse;
import com.proyecto.listaPendientes.domain.port.out.AuthenticationServiceOut;
import com.proyecto.listaPendientes.domain.port.out.JWTServiceOut;
import com.proyecto.listaPendientes.infrastructure.entity.UsuarioEntity;
import com.proyecto.listaPendientes.infrastructure.mapper.UsuarioMapper;
import com.proyecto.listaPendientes.infrastructure.repository.RolRepository;
import com.proyecto.listaPendientes.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
@RequiredArgsConstructor
public class AuthenticationAdapter implements AuthenticationServiceOut {
    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTServiceOut jwtServiceOut;
    private final RolRepository rolRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO signUpUser(SignUpRequest signUpRequest) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombreUsuario(signUpRequest.getNombre());
        usuario.setApellidosUsuario(signUpRequest.getApellido());
        usuario.setEmail(signUpRequest.getEmail());
        usuario.setRol(rolRepository.findByNombreRol(signUpRequest.getRole()));
        usuario.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        usuario.setEstadoUsuario(Constants.STATUS_ACTIVE);
        usuario.setUserCreate(Constants.AUDIT_ADMIN);
        usuario.setUserDateCreate(getTimestamp());
        usuarioRepository.save(usuario);
        return  usuarioMapper.mapToDTO(usuario);
    }

    @Override
    public UsuarioDTO signUpAdmin(SignUpRequest signUpRequest) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombreUsuario(signUpRequest.getNombre());
        usuario.setApellidosUsuario(signUpRequest.getApellido());
        usuario.setEmail(signUpRequest.getEmail());
        usuario.setRol(rolRepository.findByNombreRol("ADMIN"));
        usuario.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        usuario.setEstadoUsuario(Constants.STATUS_ACTIVE);
        usuario.setUserCreate(Constants.AUDIT_ADMIN);
        usuario.setUserDateCreate(getTimestamp());
        return  usuarioMapper.mapToDTO(usuario);
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getEmail(), signInRequest.getPassword()));
        var user = usuarioRepository.findByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Email no valido"));

        var jwt = jwtServiceOut.generarTokenOut(user);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwt);
        return authenticationResponse;
    }

    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return timestamp;
    }
}

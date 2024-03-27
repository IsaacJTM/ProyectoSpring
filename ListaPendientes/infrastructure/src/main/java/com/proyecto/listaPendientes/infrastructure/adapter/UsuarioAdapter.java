package com.proyecto.listaPendientes.infrastructure.adapter;

import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
import com.proyecto.listaPendientes.domain.aggregates.response.ResponseBase;
import com.proyecto.listaPendientes.domain.port.out.UsuarioServiceOut;
import com.proyecto.listaPendientes.infrastructure.entity.UsuarioEntity;
import com.proyecto.listaPendientes.infrastructure.mapper.UsuarioMapper;
import com.proyecto.listaPendientes.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioAdapter implements UsuarioServiceOut {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public ResponseBase getUsuarioOut(Long id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            return  new ResponseBase(404,"Dato no encontrado", false,Optional.empty());
        }
        UsuarioDTO dto = usuarioMapper.mapToDTO(usuario.get());
        return new ResponseBase(201,"Dato encontrado",true,
                Optional.of(dto));
    }

    @Override
    public ResponseBase updateUsuarioOut(Long id, UsuarioDTO usuario) {
        return null;
    }

    @Override
    public ResponseBase deleteUsuarioOut(Long id) {
        return null;
    }

    @Override
    public ResponseBase obtenerTodasOut() {
        List<UsuarioDTO> listUsers = new ArrayList<>();
        List<UsuarioEntity> usuariosBD = usuarioRepository.findAll();
        for(UsuarioEntity  usuarios : usuariosBD){
            UsuarioDTO usuarioDTO = usuarioMapper.mapToDTO(usuarios);
            listUsers.add(usuarioDTO);
        }
        return new ResponseBase(200,"Listado",true, Optional.of(listUsers));
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return usuarioRepository.findByEmail(username).orElseThrow(()->
                        new UsernameNotFoundException("Usuario no encontrado"));
            }
        };
    }
}

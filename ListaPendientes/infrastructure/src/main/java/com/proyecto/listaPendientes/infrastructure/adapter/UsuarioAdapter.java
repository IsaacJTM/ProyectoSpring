package com.proyecto.listaPendientes.infrastructure.adapter;

import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
import com.proyecto.listaPendientes.domain.port.out.UsuarioServiceOut;
import com.proyecto.listaPendientes.infrastructure.entity.UsuarioEntity;
import com.proyecto.listaPendientes.infrastructure.mapper.UsuarioMapper;
import com.proyecto.listaPendientes.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioAdapter implements UsuarioServiceOut {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public Optional<UsuarioDTO> getUsuarioOut(Long id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            return  null;
        }
        UsuarioDTO dto = usuarioMapper.mapToDTO(usuario.get());
        return Optional.of(dto);
    }

    @Override
    public UsuarioDTO updateUsuarioOut(Long id, UsuarioDTO usuario) {
        return null;
    }

    @Override
    public UsuarioDTO deleteUsuarioOut(Long id) {
        return null;
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

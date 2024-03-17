package com.proyecto.listaPendientes.infrastructure.mapper;

import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
import com.proyecto.listaPendientes.infrastructure.entity.UsuarioEntity;
import org.modelmapper.ModelMapper;

public class UsuarioMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public UsuarioDTO mapToDTO(UsuarioEntity usuarioEntity){
        return modelMapper.map(usuarioEntity, UsuarioDTO.class);
    }

    public UsuarioEntity mapToEntity(UsuarioDTO usuarioDTO){
        return modelMapper.map(usuarioDTO, UsuarioEntity.class);
    }

}

package com.proyecto.listaPendientes.infrastructure.patAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.listaPendientes.domain.aggregates.dto.TareaDTO;
import com.proyecto.listaPendientes.domain.aggregates.dto.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Getter
@Setter
@Component
public class PatAdapter {

   public static String convertToJson(UsuarioDTO usuarioDTO){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(usuarioDTO);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    public static String convertToJson(TareaDTO tareaDTO){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(tareaDTO);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    /*public static String convertToJson(Optional claseDto){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(claseDto);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }*/
    public static <T> T convertFromJson(String json, Class<T> valueType){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json,valueType);

        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}

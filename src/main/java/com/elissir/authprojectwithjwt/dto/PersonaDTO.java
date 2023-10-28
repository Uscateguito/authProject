package com.elissir.authprojectwithjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaDTO {

    private Long id_persona;
    private String nombre;
    private String apellido;
    private String correoElectronico;

}


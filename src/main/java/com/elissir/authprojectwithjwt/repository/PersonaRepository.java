package com.elissir.authprojectwithjwt.repository;

import com.elissir.authprojectwithjwt.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Persona findFirstByCorreoElectronico(String correo_electronico);
}

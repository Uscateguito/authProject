package com.elissir.authprojectwithjwt.repository;

import com.elissir.authprojectwithjwt.entidades.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findFirstByNombre(String nombre);
}

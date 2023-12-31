package com.elissir.authprojectwithjwt.security;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.elissir.authprojectwithjwt.repository.AdminRepository;
import com.elissir.authprojectwithjwt.repository.PersonaRepository;

// Para respetar el pipeline tenemos que configurar el authenticatoin Manager
// El proveedor
// y el passwordEncoder
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final PersonaRepository personaRepository;
    private final AdminRepository adminRepository;
    Logger logger = org.slf4j.LoggerFactory.getLogger(ApplicationConfig.class);

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        return username -> {
//            logger.warn("este es el username que llega: " + username);
            if (personaRepository.findFirstByCorreoElectronico(username) != null) {
                return personaRepository.findFirstByCorreoElectronico(username);
            } else if (adminRepository.findFirstByNombre(username) != null) {
                return adminRepository.findFirstByNombre(username);
            } else {
                throw new RuntimeException("Usuario no encontrado");
            }
        };
    }


}

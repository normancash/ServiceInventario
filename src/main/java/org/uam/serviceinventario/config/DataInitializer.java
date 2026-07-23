package org.uam.serviceinventario.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.uam.serviceinventario.model.Administrador;
import org.uam.serviceinventario.repository.AdministradorRepo;

import java.util.UUID;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDB(AdministradorRepo repo) {
        return args -> {
            if (repo.count() == 0) {
                Administrador administrador = new Administrador();
                administrador.setNombre("Norman");
                administrador.setApellido("Cash");
                //administrador.setUuid(UUID.randomUUID());
                repo.save(administrador);
            }
        };
    }
}

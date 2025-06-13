package fr.mbds.itu.poste_service;

import fr.mbds.itu.poste_service.entities.Poste;
import fr.mbds.itu.poste_service.repositories.PosteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class PosteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PosteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PosteRepository posteRepository) {
        return args -> {
            List<Poste> postes = List.of(
                    Poste.builder()
                            .id("CEO")
                            .nom("Chief Executive Officer")
                            .build(),
                    Poste.builder()
                            .id("CO")
                            .nom("Chief Technical Officer")
                            .build(),
                    Poste.builder()
                            .id("DAF")
                            .nom("Directeur Administrateur Financier")
                            .build(),
                    Poste.builder()
                            .id("DRH")
                            .nom("Directeur Ressource Humain")
                            .build()
            );
            posteRepository.saveAll(postes);
        };
    }

}

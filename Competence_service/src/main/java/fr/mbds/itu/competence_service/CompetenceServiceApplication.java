package fr.mbds.itu.competence_service;

import fr.mbds.itu.competence_service.entities.Competence;
import fr.mbds.itu.competence_service.repositories.CompetenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class CompetenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompetenceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CompetenceRepository competenceRepository) {
        return args -> {
            List<Competence> competences = List.of(
                Competence.builder()
                        .nom("nom1")
                        .build(),
                Competence.builder()
                        .nom("nom2")
                        .build(),
                Competence.builder()
                        .nom("nom3")
                        .build()
            );
            competenceRepository.saveAll(competences);
        };
    }
}

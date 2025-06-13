package fr.mbds.itu.poste_service;

import fr.mbds.itu.poste_service.clients.CompetenceClient;
import fr.mbds.itu.poste_service.entities.Poste;
import fr.mbds.itu.poste_service.models.Competence;
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
    CommandLineRunner commandLineRunner(PosteRepository posteRepository, CompetenceClient competenceClient) {
        List<Competence> competences = competenceClient.getAllCompetences();
        return args -> {
            List<Poste> postes = List.of(
                    Poste.builder()
                            .id("CEO")
                            .nom("Chief Executive Officer")
                            .competenceIds(List.of(competences.get(0).getId(), competences.get(1).getId()))
                            .competences(List.of(competences.get(0), competences.get(1)))
                            .build(),
                    Poste.builder()
                            .id("CO")
                            .nom("Chief Technical Officer")
                            .competenceIds(List.of(competences.get(3).getId(), competences.get(2).getId()))
                            .competences(List.of(competences.get(3), competences.get(2)))
                            .build(),
                    Poste.builder()
                            .id("DAF")
                            .nom("Directeur Administrateur Financier")
                            .competenceIds(List.of(competences.get(4).getId(), competences.get(5).getId()))
                            .competences(List.of(competences.get(4), competences.get(5)))
                            .build(),
                    Poste.builder()
                            .id("DRH")
                            .nom("Directeur Ressource Humain")
                            .competenceIds(List.of(competences.get(3).getId(), competences.get(2).getId()))
                            .competences(List.of(competences.get(3), competences.get(2)))
                            .build()
            );
            posteRepository.saveAll(postes);
        };
    }

}

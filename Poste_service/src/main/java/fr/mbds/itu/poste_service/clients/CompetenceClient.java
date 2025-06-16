package fr.mbds.itu.poste_service.clients;

import fr.mbds.itu.poste_service.models.Competence;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "COMPETENCE")
public interface CompetenceClient {
    @GetMapping("/skill/{id}")
    @CircuitBreaker(name = "competence", fallbackMethod = "getDefaultCompetence")
    Competence getCompetenceById(@PathVariable Long id);
    @GetMapping("/skills")
    @CircuitBreaker(name = "competence", fallbackMethod = "getAllCompetence")
    List<Competence> getAllCompetences();

    default List<Competence> getAllCompetence(Exception exception) {
        return List.of(Competence.builder().nom("Competence service not available").build());
    }

    default Competence getDefaultCompetence(Long id, Exception exception) {
        Competence competence = new Competence();
        competence.setId(id);
        competence.setNom("Competence service not available");
        return competence;
    }
}

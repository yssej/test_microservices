package fr.mbds.itu.competence_service.clients;

import fr.mbds.itu.competence_service.models.Poste;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "POSTE")
public interface PosteClient {
    @GetMapping("/poste/{id}")
    @CircuitBreaker(name = "poste", fallbackMethod = "getDefaultPoste")
    Poste getPoste(@PathVariable String id);
    @GetMapping("/poste/competence/{id}")
    @CircuitBreaker(name = "poste", fallbackMethod = "getDefaultListPoste")
    List<Poste> getPosteByCompetenceId(@PathVariable Long id);

    default Poste getDefaultPoste(String id, Exception exception) {
        Poste poste = new Poste();
        poste.setId(id);
        poste.setNom("Not available");
        poste.setCompetenceIds(null);
        return poste;
    }

    default List<Poste> getDefaultListPoste(Exception exception) {
        return List.of(Poste.builder().nom("Poste service not available").build());
    }
}

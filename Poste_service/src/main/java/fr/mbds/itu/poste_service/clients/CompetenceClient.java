package fr.mbds.itu.poste_service.clients;

import fr.mbds.itu.poste_service.models.Competence;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "COMPETENCE")
public interface CompetenceClient {
    @GetMapping("/skill/{id}")
    Competence getCompetenceById(@PathVariable Long id);
    @GetMapping("/skills")
    List<Competence> getAllCompetences();
}

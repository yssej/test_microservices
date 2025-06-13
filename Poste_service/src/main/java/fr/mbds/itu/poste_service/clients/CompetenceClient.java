package fr.mbds.itu.poste_service.clients;

import fr.mbds.itu.poste_service.models.Competence;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "competence", url = "localhost:8081")
public interface CompetenceClient {
    @GetMapping("/skill/{id}")
    public Competence getCompetenceById(@PathVariable Long id);
    @GetMapping("/skills")
    public List<Competence> getAllCompetences();
}

package fr.mbds.itu.poste_service.clients;

import fr.mbds.itu.poste_service.models.Competence;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "competence", url = "localhost:8080")
public interface CompetenceClient {
    @GetMapping
    public Competence getCompetenceById(@RequestParam("id") long id);
    @GetMapping
    public List<Competence> getAllCompetences();
}

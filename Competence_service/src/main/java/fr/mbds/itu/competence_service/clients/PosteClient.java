package fr.mbds.itu.competence_service.clients;

import fr.mbds.itu.competence_service.models.Poste;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "poste", url = "localhost:8080")
public interface PosteClient {
    @GetMapping("/poste/{id}")
    Poste getPoste(@PathVariable Long id);
    @GetMapping("/poste/competence/{id}")
    List<Poste> getPosteByCompetenceId(@PathVariable Long id);
}

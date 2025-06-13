package fr.mbds.itu.competence_service.controllers;

import fr.mbds.itu.competence_service.dtos.CompetenceDTO;
import fr.mbds.itu.competence_service.services.CompetenceService;
import fr.mbds.itu.competence_service.services.CompetenceServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompetenceController {
    private final CompetenceServiceImpl competenceServiceImpl;

    public CompetenceController(CompetenceServiceImpl competenceServiceImpl) {
        this.competenceServiceImpl = competenceServiceImpl;
    }

    @GetMapping("/skills")
    public List<CompetenceDTO> getCompetences() {
        return competenceServiceImpl.findAll();
    }

    @GetMapping("/skill/{id}")
    public CompetenceDTO getCompetenceById(@PathVariable Long id) {
        return competenceServiceImpl.findById(id);
    }
}

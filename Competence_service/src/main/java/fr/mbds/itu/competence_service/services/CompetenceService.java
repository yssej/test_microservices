package fr.mbds.itu.competence_service.services;

import fr.mbds.itu.competence_service.dtos.CompetenceDTO;

import java.util.List;

public interface CompetenceService {
    List<CompetenceDTO> findAll();
    CompetenceDTO findById(Long id);
}

package fr.mbds.itu.poste_service.services;

import fr.mbds.itu.poste_service.dtos.PosteDTO;

import java.util.List;

public interface PosteService {
    List<PosteDTO> findAll();
    PosteDTO findById(String id);
    List<PosteDTO> findByCompetenceId(Long competenceId);
}

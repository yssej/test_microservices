package fr.mbds.itu.poste_service.mappers;

import fr.mbds.itu.poste_service.dtos.PosteDTO;
import fr.mbds.itu.poste_service.entities.Poste;
import org.springframework.stereotype.Component;

@Component
public class PosteMapper {
    public PosteDTO toDTO(Poste poste) {
        return new PosteDTO(poste.getId(), poste.getNom(), poste.getCompetenceIds(), poste.getCompetences());
    }

    public Poste toEntity(PosteDTO posteDTO) {
        if(posteDTO != null) {
            return new Poste(posteDTO.getId(), posteDTO.getNom(), posteDTO.getCompetenceIds(), posteDTO.getCompetences());
        }
        return null;
    }
}

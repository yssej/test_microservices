package fr.mbds.itu.competence_service.mappers;

import fr.mbds.itu.competence_service.dtos.CompetenceDTO;
import fr.mbds.itu.competence_service.entities.Competence;
import org.springframework.stereotype.Component;

@Component
public class CompetenceMapper {
    public CompetenceDTO toDTO(Competence competence) {
        return new CompetenceDTO(competence.getId(), competence.getNom(), competence.getPostes());
    }
    public Competence toEntity(CompetenceDTO competenceDTO) {
        if(competenceDTO != null)
            return new Competence(competenceDTO.getId(), competenceDTO.getNom(), competenceDTO.getPostes());
        return null;
    }
}

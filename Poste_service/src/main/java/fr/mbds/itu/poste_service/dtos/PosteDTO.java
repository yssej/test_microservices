package fr.mbds.itu.poste_service.dtos;

import fr.mbds.itu.poste_service.models.Competence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class PosteDTO {
    private String id;
    private String nom;
    private List<Long> competenceIds;
    private List<Competence> competences;

    public void addCompetence(Competence competence) {
        competences.add(competence);
    }
}

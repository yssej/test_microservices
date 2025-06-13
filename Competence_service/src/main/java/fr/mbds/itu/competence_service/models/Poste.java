package fr.mbds.itu.competence_service.models;

import fr.mbds.itu.competence_service.entities.Competence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class Poste {
    private String id;
    private String nom;
    private List<Long> competenceIds;
    private List<Competence> competences;
}

package fr.mbds.itu.competence_service.dtos;

import fr.mbds.itu.competence_service.models.Poste;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class CompetenceDTO {
    private Long id;
    private String nom;
    private List<Poste> postes;
}

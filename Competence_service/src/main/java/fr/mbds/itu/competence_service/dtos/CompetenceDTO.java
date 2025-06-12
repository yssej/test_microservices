package fr.mbds.itu.competence_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class CompetenceDTO {
    private Long id;
    private String nom;
}

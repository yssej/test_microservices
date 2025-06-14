package fr.mbds.itu.competence_service.entities;

import fr.mbds.itu.competence_service.models.Poste;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Transient
    private List<Poste> postes;

}

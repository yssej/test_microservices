package fr.mbds.itu.poste_service.entities;

import fr.mbds.itu.poste_service.models.Competence;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Poste {

    @Id
    private String id;
    private String nom;
    @ElementCollection
    @CollectionTable(
            name = "posteCompetences",
            joinColumns = @JoinColumn(
                    name = "posteId",
                    referencedColumnName = "id"
            )
    )
    @Column(name = "competenceId")
    private List<Long> competenceIds = new ArrayList<>();

    @Transient
    private List<Competence> competences;
}

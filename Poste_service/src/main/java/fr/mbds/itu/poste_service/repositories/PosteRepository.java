package fr.mbds.itu.poste_service.repositories;

import fr.mbds.itu.poste_service.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteRepository extends JpaRepository<Poste, String> {
    @Query("SELECT p FROM Poste p WHERE SIZE(p.competenceIds) > 0 AND :competenceId MEMBER OF p.competenceIds")
    List<Poste> findPosteWithOnlyOneCompetence(@Param("competenceId") Long competenceId);

}

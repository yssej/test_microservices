package fr.mbds.itu.competence_service.repositories;

import fr.mbds.itu.competence_service.entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
}

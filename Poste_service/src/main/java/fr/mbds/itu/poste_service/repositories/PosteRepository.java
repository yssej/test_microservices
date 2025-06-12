package fr.mbds.itu.poste_service.repositories;

import fr.mbds.itu.poste_service.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteRepository extends JpaRepository<Poste, String> {
}

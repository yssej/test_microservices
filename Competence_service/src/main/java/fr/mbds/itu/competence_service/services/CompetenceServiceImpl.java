package fr.mbds.itu.competence_service.services;

import fr.mbds.itu.competence_service.dtos.CompetenceDTO;
import fr.mbds.itu.competence_service.mappers.CompetenceMapper;
import fr.mbds.itu.competence_service.repositories.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenceServiceImpl implements CompetenceService {
    private final CompetenceRepository competenceRepository;
    private final CompetenceMapper competenceMapper;

    public CompetenceServiceImpl(CompetenceRepository competenceRepository, CompetenceMapper competenceMapper) {
        this.competenceRepository = competenceRepository;
        this.competenceMapper = competenceMapper;
    }

    @Override
    public List<CompetenceDTO> findAll() {
        return competenceRepository.findAll().stream().map(competenceMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CompetenceDTO findById(Long id) {
        return competenceRepository.findById(id).map(competenceMapper::toDTO).orElse(null);
    }
}

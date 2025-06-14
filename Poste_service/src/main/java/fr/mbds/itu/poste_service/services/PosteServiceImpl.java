package fr.mbds.itu.poste_service.services;

import fr.mbds.itu.poste_service.clients.CompetenceClient;
import fr.mbds.itu.poste_service.dtos.PosteDTO;
import fr.mbds.itu.poste_service.mappers.PosteMapper;
import fr.mbds.itu.poste_service.models.Competence;
import fr.mbds.itu.poste_service.repositories.PosteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PosteServiceImpl implements PosteService {
    private final PosteRepository posteRepository;
    private final PosteMapper posteMapper;
    private final CompetenceClient competenceClient;
    public PosteServiceImpl(PosteRepository posteRepository, PosteMapper posteMapper,
                            CompetenceClient competenceClient) {
        this.posteRepository = posteRepository;
        this.posteMapper = posteMapper;
        this.competenceClient = competenceClient;
    }
    @Override
    public List<PosteDTO> findAll() {
        return posteRepository.findAll().stream().map(posteMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public PosteDTO findById(String id) {
        PosteDTO posteDTO = posteRepository.findById(id).map(posteMapper::toDTO).orElse(null);
        if(posteDTO != null) {
            List<Competence> posteCompetences = new ArrayList<>();
            for(Long Id : posteDTO.getCompetenceIds())
                posteCompetences.add(competenceClient.getCompetenceById(Id));
            posteDTO.setCompetences(posteCompetences);
            return posteDTO;
        }
        return null;
    }

    @Override
    public List<PosteDTO> findByCompetenceId(Long competenceId) {
        return posteRepository.findPosteWithOnlyOneCompetence(competenceId).stream().map(posteMapper::toDTO).collect(Collectors.toList());
    }
}

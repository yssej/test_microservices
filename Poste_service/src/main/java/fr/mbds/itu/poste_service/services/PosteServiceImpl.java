package fr.mbds.itu.poste_service.services;

import fr.mbds.itu.poste_service.dtos.PosteDTO;
import fr.mbds.itu.poste_service.mappers.PosteMapper;
import fr.mbds.itu.poste_service.repositories.PosteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PosteServiceImpl implements PosteService {
    private final PosteRepository posteRepository;
    private final PosteMapper posteMapper;
    public PosteServiceImpl(PosteRepository posteRepository, PosteMapper posteMapper) {
        this.posteRepository = posteRepository;
        this.posteMapper = posteMapper;
    }
    @Override
    public List<PosteDTO> findAll() {
        return posteRepository.findAll().stream().map(posteMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public PosteDTO findById(String id) {
        return posteRepository.findById(id).map(posteMapper::toDTO).orElse(null);
    }
}

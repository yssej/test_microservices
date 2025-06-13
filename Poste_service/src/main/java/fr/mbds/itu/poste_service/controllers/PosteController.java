package fr.mbds.itu.poste_service.controllers;

import fr.mbds.itu.poste_service.dtos.PosteDTO;
import fr.mbds.itu.poste_service.services.PosteServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PosteController {
    private final PosteServiceImpl posteService;
    public PosteController(PosteServiceImpl posteService) {
        this.posteService = posteService;
    }
    @GetMapping("/postes")
    public List<PosteDTO> findAll() {
        return posteService.findAll();
    }
    @GetMapping("/poste/{id}")
    public PosteDTO findById(@PathVariable String id) {
        return posteService.findById(id);
    }
}

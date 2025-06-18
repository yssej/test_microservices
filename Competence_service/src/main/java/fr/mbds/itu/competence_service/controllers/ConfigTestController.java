package fr.mbds.itu.competence_service.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
//    @Value("${a}")
    private int a = 10;
//    @Value("${b}")
    private int b = 20;
//    @Value("${c}")
    private int c = 30;

    @GetMapping("/testConfig")
    public Map<String, Integer> testConfig() {
        return Map.of("a", a, "b", b, "c", c);
    }
}

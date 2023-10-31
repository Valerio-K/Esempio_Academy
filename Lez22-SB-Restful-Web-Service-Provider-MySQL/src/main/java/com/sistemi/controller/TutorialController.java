package com.sistemi.controller;

import com.sistemi.entity.Tutorial;
import com.sistemi.service.TutorialServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/api/tutorials")
public class TutorialController {

    @Autowired
    TutorialServiceI serv;

    @GetMapping
    public List<Tutorial> getTutorials() {
        return serv.findAllTutorials();
    }

    @GetMapping("/id/{id}")
    public Tutorial getTutorialsById(@PathVariable Integer id) {
        return serv.findTutorialById(id);
    }

    @GetMapping("/name/{name}")
    public List<Tutorial> getTutorialsByName(@PathVariable String name) {
        return serv.findTutorialsByName(name);
    }

    @PostMapping
    public Tutorial postTutorials(@RequestBody Tutorial tutorial) {
        return serv.saveOrUpdateTutorial(tutorial);
    }

    @PutMapping
    public Tutorial putTutorial(@RequestBody Tutorial tutorial) {
        return serv.saveOrUpdateTutorial(tutorial);
    }

    @DeleteMapping("/id/{id}")
    public Map<String, Boolean> deleteTutorial(@PathVariable Integer id) {
        return serv.deleteTutorial(id);
    }
}

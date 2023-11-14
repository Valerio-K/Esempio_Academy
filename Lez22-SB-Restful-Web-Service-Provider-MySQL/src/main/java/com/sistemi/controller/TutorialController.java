package com.sistemi.controller;

import com.sistemi.entity.Tutorial;
import com.sistemi.service.TutorialServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/rest/api/tutorials")
public class TutorialController {

    @Autowired
    TutorialServiceI serv;

    //http://localhost:9090/rest/api/tutorials {GET}
    @GetMapping
    public List<Tutorial> getTutorials() {
        return serv.findAllTutorials();
    }

    //http://localhost:9090/rest/api/tutorials/id/idTutorial {GET}
    @GetMapping("/id/{id}")
    public Tutorial getTutorialsById(@PathVariable Integer id) {
        return serv.findTutorialById(id);
    }

    //http://localhost:9090/rest/api/tutorials/id/nomeTutorial {GET}
    @GetMapping("/name/{name}")
    public List<Tutorial> getTutorialsByName(@PathVariable String name) {
        return serv.findTutorialsByName(name);
    }

    //http://localhost:9090/rest/api/tutorials {POST}
    @PostMapping
    public Tutorial postTutorials(@RequestBody Tutorial tutorial) {
        return serv.saveOrUpdateTutorial(tutorial);
    }

    //http://localhost:9090/rest/api/tutorials {PUT}
    @PutMapping
    public Tutorial putTutorial(@RequestBody Tutorial tutorial) {
        return serv.saveOrUpdateTutorial(tutorial);
    }

    //http://localhost:9090/rest/api/tutorials/id/idTutorial {DELETE}
    @DeleteMapping("/id/{id}")
    public Map<String, Boolean> deleteTutorial(@PathVariable Integer id) {
        return serv.deleteTutorial(id);
    }
}

package com.sistemi.service;

import com.sistemi.entity.Tutorial;
import com.sistemi.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TutorialService implements TutorialServiceI {

    @Autowired
    private TutorialRepository repo;

    @Override
    public Tutorial saveOrUpdateTutorial(Tutorial tutorial) {
        return repo.save(tutorial);
    }

    @Override
    public Map<String, Boolean> deleteTutorial(Integer id) {
        Map<String, Boolean> deletionMap = new HashMap<>();
        try {
            repo.deleteById(id);
            deletionMap.put("deletion", true);
        } catch(IllegalArgumentException ex) {
            deletionMap.put("deletion", false);
        }
        return deletionMap;
    }

    @Override
    public List<Tutorial> findAllTutorials() {
        return repo.findAll();
    }

    @Override
    public List<Tutorial> findTutorialsByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Tutorial findTutorialById(Integer id) {
        return repo.findById(id).orElseThrow();
    }
}

package com.sistemi.service;

import com.sistemi.entity.Tutorial;

import java.util.List;
import java.util.Map;

public interface TutorialServiceI {
    public Tutorial saveOrUpdateTutorial(Tutorial tutorial);

    public Map<String, Boolean> deleteTutorial(Integer id);

    public List<Tutorial> findAllTutorials();

    public List<Tutorial> findTutorialsByName(String name);

    public Tutorial findTutorialById(Integer id);
}

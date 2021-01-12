package com.project.nitk.controller;


import com.project.nitk.model.AchievementData;
import com.project.nitk.repository.AchievementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achievements")
public class AchievementController {

    @Autowired
    private AchievementRepo achievementRepo;

    @GetMapping("/get")
    @CrossOrigin
    public ResponseEntity<List<AchievementData>> getAchievements(){
        List<AchievementData> response = (List<AchievementData>) achievementRepo.findAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<AchievementData> addAchievementData(@RequestBody AchievementData achievementData){
        return ResponseEntity.ok(achievementRepo.save(achievementData));
    }

}

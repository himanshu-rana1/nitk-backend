package com.project.nitk.repository;

import com.project.nitk.model.AchievementData;
import org.springframework.data.repository.CrudRepository;

public interface AchievementRepo extends CrudRepository<AchievementData, Long> {
}

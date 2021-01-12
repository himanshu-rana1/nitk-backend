package com.project.nitk.repository;

import com.project.nitk.model.BTechStatistics;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BtechRepo extends CrudRepository<BTechStatistics, Long> {

    List<BTechStatistics> findByYearFromBetween(int start, int end);
}

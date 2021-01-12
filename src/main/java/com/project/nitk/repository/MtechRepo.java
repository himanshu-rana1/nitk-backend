package com.project.nitk.repository;

import com.project.nitk.model.MTechStatistics;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MtechRepo extends CrudRepository<MTechStatistics, Long> {

    List<MTechStatistics> findByYearFromBetween(int start, int end);
}

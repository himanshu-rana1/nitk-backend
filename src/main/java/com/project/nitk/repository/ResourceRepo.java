package com.project.nitk.repository;

import com.project.nitk.model.Resource;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepo extends CrudRepository<Resource, Long> {

    public Resource findResourceByCourseAndYearAndDocumentName(String course, Integer year, String documentName);
}

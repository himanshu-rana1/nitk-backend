package com.project.nitk.controller;

import com.project.nitk.model.Resource;
import com.project.nitk.model.request.ResourceRequest;
import com.project.nitk.repository.ResourceRepo;
import com.project.nitk.util.MediaUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceRepo resourceRepo;

    @CrossOrigin
    @GetMapping(value = "/get/{course}/{year}/{documentName}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getResourceBasedOnCourse(@PathVariable String course,@PathVariable Integer year,@PathVariable String documentName){
        try {
            Resource resource = resourceRepo.findResourceByCourseAndYearAndDocumentName(course, year, documentName);
            System.out.println("course : "+ resource.getCourse());
            return ResponseEntity.ok().body(resource.getFile());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Resource> addResource(@ModelAttribute ResourceRequest resourceRequest){
        if(resourceRequest != null){
            try {
                Resource resource = new Resource(resourceRequest.getCourse(), resourceRequest.getDocumentName(),
                        resourceRequest.getYear(), resourceRequest.getFile().getBytes());

                return ResponseEntity.ok(resourceRepo.save(resource));
            } catch (IOException e){
                System.out.println(e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}

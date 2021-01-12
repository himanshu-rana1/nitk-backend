package com.project.nitk.controller;

import com.project.nitk.model.BTechStatistics;
import com.project.nitk.model.Resource;
import com.project.nitk.model.request.ResourceRequest;
import com.project.nitk.model.response.BtechStatResponse;
import com.project.nitk.repository.BtechRepo;
import com.project.nitk.repository.ResourceRepo;
import com.project.nitk.util.MediaUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.activation.MimeType;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/btech")
public class BtechController {

    @Autowired
    private BtechRepo btechRepo;

    @GetMapping("/getPlacementData")
    @CrossOrigin
    public ResponseEntity<List<BtechStatResponse>> getBTechStatistics(){
        List<BTechStatistics> bStats = btechRepo.findByYearFromBetween(LocalDate.now().getYear()-6, LocalDate.now().getYear()+1);
        List<BtechStatResponse> stats = bStats.stream().sorted(Comparator.comparing(BTechStatistics::getYearFrom))
                .map(m -> new BtechStatResponse(m.getTotalStudents(), m.getTotalPlacements())).collect(Collectors.toList());
        return ResponseEntity.ok().body(stats);
    }

    @PostMapping("/addData")
    public ResponseEntity<BTechStatistics> addData(@RequestBody BTechStatistics statistics){
        return ResponseEntity.ok().body(btechRepo.save(statistics));
    }
}

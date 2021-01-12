package com.project.nitk.controller;

import com.project.nitk.model.MTechStatistics;
import com.project.nitk.model.response.MtechStatResponse;
import com.project.nitk.repository.MtechRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mtech")
public class MtechController {

    @Autowired
    private MtechRepo mtechRepo;

    @GetMapping("/getPlacementData")
    @CrossOrigin
    public ResponseEntity<List<MtechStatResponse>> getMTechStatistics(){
        List<MTechStatistics> mstats = mtechRepo.findByYearFromBetween(LocalDate.now().getYear()-6, LocalDate.now().getYear()+1);
        List<MtechStatResponse> stats = mstats.stream().sorted(Comparator.comparing(MTechStatistics::getYearFrom))
                                .map(m -> new MtechStatResponse(m.getTotalStudents(), m.getTotalPlacements())).collect(Collectors.toList());
        return ResponseEntity.ok().body(stats);
    }

    @PostMapping("/addData")
    public ResponseEntity<MTechStatistics> addData(@RequestBody MTechStatistics statistics){
        return ResponseEntity.ok().body(mtechRepo.save(statistics));
    }
}

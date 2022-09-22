package com.aseneg.superhero.jpa.h2.controller;

import java.util.List;

import com.aseneg.superhero.jpa.h2.interfaces.MutantService;
import com.aseneg.superhero.jpa.h2.model.HistoricalMutant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aseneg.superhero.jpa.h2.repository.LaboratoryRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class SuperMutantController {

    @Autowired
    LaboratoryRepository laboratoryRepository;

    @Autowired
    MutantService mutantService;

    @GetMapping("mutant")
    public ResponseEntity<String> getMutants(@RequestBody List<String> dna) {
        try {
            if (mutantService.valideMutant(dna).isEmpty()) {
                mutantService.insertHistorical(dna, "false");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            mutantService.insertHistorical(dna, "true");
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("stats")
    public ResponseEntity<HistoricalMutant> getEstadMutants() {
        return new ResponseEntity<>(mutantService.consultAvg(), HttpStatus.OK);
    }

}

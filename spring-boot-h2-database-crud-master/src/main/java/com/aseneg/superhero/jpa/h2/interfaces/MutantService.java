package com.aseneg.superhero.jpa.h2.interfaces;

import com.aseneg.superhero.jpa.h2.model.DnaEntity;
import com.aseneg.superhero.jpa.h2.model.HistoricalMutant;

import java.util.List;

public interface MutantService {

    List<DnaEntity> valideMutant(List<String> dna);

    void insertHistorical(List<String> dna, String result);

    HistoricalMutant consultAvg();

}

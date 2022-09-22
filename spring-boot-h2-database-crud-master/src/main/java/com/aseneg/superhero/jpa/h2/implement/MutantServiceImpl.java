package com.aseneg.superhero.jpa.h2.implement;

import com.aseneg.superhero.jpa.h2.interfaces.MutantService;
import com.aseneg.superhero.jpa.h2.model.DnaEntity;
import com.aseneg.superhero.jpa.h2.model.HistoricalDnaEntity;
import com.aseneg.superhero.jpa.h2.model.HistoricalMutant;
import com.aseneg.superhero.jpa.h2.repository.HistoricalRepository;
import com.aseneg.superhero.jpa.h2.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MutantServiceImpl implements MutantService {

    @Autowired
    LaboratoryRepository laboratoryRepository;

    @Autowired
    HistoricalRepository historicalRepository;

    @Override
    public List<DnaEntity> valideMutant(List<String> dna) {

        List<DnaEntity> dnaEntities = new ArrayList<DnaEntity>();

        dna.forEach(dataDna -> {
            List<DnaEntity> value = laboratoryRepository.findByDna(dataDna);
            if (value.size() > 0)
                dnaEntities.add(value.get(0));
        });

        return dnaEntities;
    }

    @Override
    public void insertHistorical(List<String> dna, String result) {
        List<HistoricalDnaEntity> historicalDnaEntities = new ArrayList<>();
        dna.forEach(infoDna -> {
            HistoricalDnaEntity historicalDnaEntity = new HistoricalDnaEntity();
            historicalDnaEntity.setDna(infoDna);
            historicalDnaEntity.setMutant(result);
            historicalDnaEntity.setDate(LocalDateTime.now());
            historicalDnaEntities.add(historicalDnaEntity);
        });

        historicalRepository.saveAll(historicalDnaEntities);

    }

    @Override
    public HistoricalMutant consultAvg(){
        HistoricalMutant historicalMutant = new HistoricalMutant();
        historicalMutant.setCountMutantDna(historicalRepository.findDataEstdis("true"));
        historicalMutant.setCountHumanDna(historicalRepository.findDataEstdis("false"));

        return historicalMutant;
    }


}

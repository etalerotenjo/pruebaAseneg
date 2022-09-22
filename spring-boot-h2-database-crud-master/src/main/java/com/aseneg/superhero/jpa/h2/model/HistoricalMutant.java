package com.aseneg.superhero.jpa.h2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricalMutant {

    private Integer countMutantDna;

    private Integer countHumanDna;

    private Integer ratio;

}

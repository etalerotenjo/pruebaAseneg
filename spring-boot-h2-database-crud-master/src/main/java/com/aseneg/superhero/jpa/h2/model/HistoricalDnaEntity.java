package com.aseneg.superhero.jpa.h2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "HISTORICAL_DNA")
public class HistoricalDnaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "DNA")
    private String dna;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "mutant")
    private String mutant;

}

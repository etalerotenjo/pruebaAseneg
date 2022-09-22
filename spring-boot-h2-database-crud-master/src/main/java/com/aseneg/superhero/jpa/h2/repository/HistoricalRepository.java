package com.aseneg.superhero.jpa.h2.repository;

import com.aseneg.superhero.jpa.h2.model.HistoricalDnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricalRepository extends JpaRepository<HistoricalDnaEntity, Long> {


    @Query(value = " select count(mutant) from historical_dna where mutant = :valor ", nativeQuery = true)
    Integer findDataEstdis(@Param("valor") String valor);

}

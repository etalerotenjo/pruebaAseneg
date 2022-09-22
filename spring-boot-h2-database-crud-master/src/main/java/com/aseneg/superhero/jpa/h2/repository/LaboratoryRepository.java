package com.aseneg.superhero.jpa.h2.repository;

import java.util.List;

import com.aseneg.superhero.jpa.h2.model.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends JpaRepository<DnaEntity, Long> {

  List<DnaEntity> findByDna(String dna);

}

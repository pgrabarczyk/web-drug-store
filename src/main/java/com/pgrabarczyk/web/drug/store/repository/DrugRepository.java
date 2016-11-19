package com.pgrabarczyk.web.drug.store.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgrabarczyk.web.drug.store.model.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Serializable> {

}

package com.pgrabarczyk.web.drug.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrabarczyk.web.drug.store.model.Drug;
import com.pgrabarczyk.web.drug.store.repository.DrugRepository;

@Service
public class DrugService {

    @Autowired
    private DrugRepository drugRepository;
    
    public List<Drug> list() {
	return drugRepository.findAll();
    }
 
}

package com.pgrabarczyk.web.drug.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrabarczyk.web.drug.store.exception.NoDrugLeftExcepotion;
import com.pgrabarczyk.web.drug.store.model.Drug;
import com.pgrabarczyk.web.drug.store.repository.DrugRepository;

import lombok.NonNull;

@Service
public class DrugService {

    @Autowired
    private DrugRepository drugRepository;

    public List<Drug> list() {
	return drugRepository.findAll();
    }

    public String buy(@NonNull Long id, int amount) throws NoDrugLeftExcepotion {
	if (amount <= 0) {
	    throw new IllegalArgumentException("Cannot buy negative value");
	}
	Drug drug = drugRepository.findById(id);
	if (drug.getAmount() < amount) {
	    throw new NoDrugLeftExcepotion(drug);
	}
	drug.setAmount(drug.getAmount() - amount);
	drugRepository.save(drug);
	return drug.getName();
    }

}

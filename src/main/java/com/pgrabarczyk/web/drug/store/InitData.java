package com.pgrabarczyk.web.drug.store;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pgrabarczyk.web.drug.store.model.Drug;
import com.pgrabarczyk.web.drug.store.repository.DrugRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InitData {

    @Autowired
    private DrugRepository drugRepository;

    @PostConstruct
    private void init() {
	log.debug("Init start");
	Drug vitC = new Drug("Vitamin C", 11);
	Drug partyPack = new Drug("Party Pack", 69);
	Drug ointment = new Drug("Ointment", 666);

	drugRepository.save(vitC);
	drugRepository.save(partyPack);
	drugRepository.save(ointment);
	log.debug("Init done");
    }
}

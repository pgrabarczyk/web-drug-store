package com.pgrabarczyk.web.drug.store.exception;

import com.pgrabarczyk.web.drug.store.model.Drug;

public class NoDrugLeftExcepotion extends Exception {

    private static final long serialVersionUID = -6685639016857177607L;

    public NoDrugLeftExcepotion(Drug drug) {
	super(String.format("No more %s to buy :(", drug.getName()));
    }

}

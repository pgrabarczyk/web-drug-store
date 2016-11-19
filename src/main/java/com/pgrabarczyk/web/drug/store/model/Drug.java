package com.pgrabarczyk.web.drug.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Drug {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int amount;
    
    public Drug(String name, int amount) {
	super();
	this.name = name;
	this.amount = amount;
    }
    
    

}

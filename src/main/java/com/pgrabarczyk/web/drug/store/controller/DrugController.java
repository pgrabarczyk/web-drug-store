package com.pgrabarczyk.web.drug.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pgrabarczyk.web.drug.store.model.Drug;
import com.pgrabarczyk.web.drug.store.service.DrugService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/")
@Slf4j
public class DrugController {

    @Autowired
    private DrugService drugService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public @ResponseBody List<Drug> list() {
	return drugService.list();
    }

    @GetMapping
    public String index(Model model) {
	List<Drug> drugList = drugService.list();
	model.addAttribute("drugList", drugList);
	return "index";
    }

    @RequestMapping(value = "buy", method = RequestMethod.POST)
    public @ResponseBody String buy(@RequestParam("id") Long id) {
	return drugService.buy(id);
    }

    @ExceptionHandler(value = Exception.class)
    public @ResponseBody String handleException(Exception ex) {
	log.error(ex.getMessage(), ex);
	return ex.toString();
    }

}

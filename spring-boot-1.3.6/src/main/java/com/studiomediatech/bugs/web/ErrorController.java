package com.studiomediatech.bugs.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;

import org.springframework.context.annotation.Profile;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Used to suppress default (BasicErrorController) functionality: By default Spring Boot adds the error path to the list
 * of paths, ignored by Spring Security.
 */
@Controller
@Profile("!without-fix")
public class ErrorController extends BasicErrorController {

    @Autowired
    public ErrorController(ErrorAttributes errorAttributes) {

        super(errorAttributes, new ErrorProperties());
    }

    @RequestMapping(value = "/error")
    public String error(Model model) {

        System.err.println("Custom error controller!");

        return "/error";
    }


    @Override
    public String getErrorPath() {

        return "/__dummyErrorPath";
    }
}

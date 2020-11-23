package com.ayan.spring.webapp.controller;


import com.ayan.spring.webapp.exception.InvalidFieldException;
import com.ayan.spring.webapp.model.Student;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/h2")
@ResponseBody
public class ResponseController {

    // ## Response Body ##
    @RequestMapping("/get")
    public String get() {
        return "response";
    }

    // ## ExceptionHandler ## //
    @PostMapping("/postex")
    public String saveStudentInformation(@RequestBody Student student) {

        if (StringUtils.isBlank(student.getName())) {
            throw new InvalidFieldException("Name is Required ");
        }

        return "Data is saved !";
    }

    @ExceptionHandler
    public String handleInvalidFieldException(InvalidFieldException invalidFieldException) {
        System.out.println("Inside Exception method !!");
        return "Hola !! " + invalidFieldException.getMessage();
    }

    // ### @Response Status ##

    // Get request
    @GetMapping("/getrequestbody")
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Data Integrity Violation ")
    public String getrequestbody() {
        return "Getting Request Body with Bad request ... ";
    }

    // with Exception Handler and post request
    @PostMapping("/getexception")
    public String getException(@RequestBody Student student) throws Exception {

        if (StringUtils.isBlank(student.getName())) {
            throw new InvalidFieldException("Bhagg .. ");
        }
        return "Data is saved ";
    }


}

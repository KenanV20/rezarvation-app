package com.example.rezarvationapp.controller;

import com.example.rezarvationapp.model.requestDto.PatientRequestDto;
import com.example.rezarvationapp.model.requestDto.ReservationRequestDto;
import com.example.rezarvationapp.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/patient")
public class PatientController {

    public final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @PostMapping
    public void addPatient(@RequestBody PatientRequestDto patientRequestDto) {
        patientService.addPatient(patientRequestDto);
    }
}

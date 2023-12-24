package com.example.rezarvationapp.controller;

import com.example.rezarvationapp.model.requestDto.AcademicDegreeRequestDto;
import com.example.rezarvationapp.model.requestDto.DoctorRequestDto;
import com.example.rezarvationapp.model.responseDto.AcademicDegreeResponseDto;
import com.example.rezarvationapp.model.responseDto.DoctorResponseDto;
import com.example.rezarvationapp.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/doctor")
public class DoctorController {

    public final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping
    public void addDoctor(@RequestBody DoctorRequestDto doctorRequestDto) {
        doctorService.addDoctor(doctorRequestDto);
    }

    @GetMapping
    public List<DoctorResponseDto> getDoctors() {
        return doctorService.getDoctors();
    }

    @GetMapping("{id}")
    public DoctorResponseDto getDoctor(@PathVariable Long id) {
        return doctorService.getDoctor(id);
    }
}

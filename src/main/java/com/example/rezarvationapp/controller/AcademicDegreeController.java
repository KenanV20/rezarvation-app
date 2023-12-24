package com.example.rezarvationapp.controller;

import com.example.rezarvationapp.model.requestDto.AcademicDegreeRequestDto;
import com.example.rezarvationapp.model.requestDto.DepartmentRequestDto;
import com.example.rezarvationapp.model.responseDto.AcademicDegreeResponseDto;
import com.example.rezarvationapp.model.responseDto.DepartmentResponseDto;
import com.example.rezarvationapp.service.AcademicDegreeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/academicDegree")
public class AcademicDegreeController {

    public final AcademicDegreeService academicDegreeService;

    public AcademicDegreeController(AcademicDegreeService academicDegreeService) {
        this.academicDegreeService = academicDegreeService;
    }


    @PostMapping
    public void addDepartment(@RequestBody AcademicDegreeRequestDto academicDegreeRequestDto) {
        academicDegreeService.addAcademicDegree(academicDegreeRequestDto);
    }

    @GetMapping
    public List<AcademicDegreeResponseDto> getAcademicDegrees(){
        return  academicDegreeService.getAcademicDegrees();
    }

}

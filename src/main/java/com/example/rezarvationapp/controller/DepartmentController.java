package com.example.rezarvationapp.controller;

import com.example.rezarvationapp.model.requestDto.DepartmentRequestDto;
import com.example.rezarvationapp.model.requestDto.PatientRequestDto;
import com.example.rezarvationapp.model.responseDto.DepartmentResponseDto;
import com.example.rezarvationapp.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/department")
public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping
    public void addDepartment(@RequestBody DepartmentRequestDto departmentRequestDto) {
        departmentService.addDepartment(departmentRequestDto);
    }

    @GetMapping
    public List<DepartmentResponseDto> getDepartments(){
        return  departmentService.getDepartments();
    }

}

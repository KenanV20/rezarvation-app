package com.example.rezarvationapp.controller;

import com.example.rezarvationapp.model.requestDto.AcademicDegreeRequestDto;
import com.example.rezarvationapp.model.requestDto.DepartmentRequestDto;
import com.example.rezarvationapp.model.responseDto.AcademicDegreeResponseDto;
import com.example.rezarvationapp.model.responseDto.DepartmentResponseDto;
import com.example.rezarvationapp.model.responseDto.SimpleMessageDto;
import com.example.rezarvationapp.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public SimpleMessageDto<DepartmentRequestDto> addDepartment(@Valid @RequestBody DepartmentRequestDto departmentRequestDto) {
        departmentService.addDepartment(departmentRequestDto);
        return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED.value());
    }

    @GetMapping
    public SimpleMessageDto<List<DepartmentResponseDto>> getDepartments() {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), departmentService.getDepartments());
    }

    @GetMapping("{id}")
    public SimpleMessageDto<DepartmentResponseDto> getDepartment(@PathVariable Long id) {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), departmentService.getDepartment(id));
    }




    @PutMapping("{id}")
    public SimpleMessageDto<DepartmentRequestDto> updateAcademicDegree(@PathVariable Long id, @Valid @RequestBody DepartmentRequestDto departmentRequestDto) {
        departmentService.updateDepartment(departmentRequestDto, id);
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
    }

    @DeleteMapping("{id}")
    public SimpleMessageDto<String> deleteDepartments(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
    }


}

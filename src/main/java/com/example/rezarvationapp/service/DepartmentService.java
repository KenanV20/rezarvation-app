package com.example.rezarvationapp.service;

import com.example.rezarvationapp.dao.entity.DepartmentEntity;
import com.example.rezarvationapp.dao.entity.ReservationEntity;
import com.example.rezarvationapp.dao.repository.DepartmentRepository;
import com.example.rezarvationapp.mapper.DepartmentMapper;
import com.example.rezarvationapp.model.requestDto.DepartmentRequestDto;
import com.example.rezarvationapp.model.requestDto.ReservationRequestDto;
import com.example.rezarvationapp.model.responseDto.DepartmentResponseDto;
import com.example.rezarvationapp.model.responseDto.ReservationResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }


    public void addDepartment(DepartmentRequestDto departmentRequestDto){

        DepartmentEntity departmentEntity=departmentMapper.dtoToEntity(departmentRequestDto);
        departmentRepository.save(departmentEntity);

    }

    public List<DepartmentResponseDto> getDepartments(){

        return departmentMapper.entityToDtos(departmentRepository.findAll());
    }
}

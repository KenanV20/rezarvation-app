package com.example.rezarvationapp.service;

import com.example.rezarvationapp.dao.entity.DepartmentEntity;
import com.example.rezarvationapp.dao.repository.DepartmentRepository;
import com.example.rezarvationapp.exception.NotFoundException;
import com.example.rezarvationapp.mapper.DepartmentMapper;
import com.example.rezarvationapp.model.requestDto.DepartmentRequestDto;
import com.example.rezarvationapp.model.responseDto.DepartmentResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }


    public void addDepartment(DepartmentRequestDto departmentRequestDto) {
        DepartmentEntity departmentEntity = departmentMapper.dtoToEntity(departmentRequestDto);
        departmentRepository.save(departmentEntity);
    }

    public List<DepartmentResponseDto> getDepartments() {
        return departmentMapper.entityToDtos(departmentRepository.findAll());
    }

    public DepartmentResponseDto getDepartment(Long id) {
        log.info("ActionLog.start  department get method with id: {}", id);

        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("DEPARTMENT_NOT_FOUND");
        });

        log.info("ActionLog.end department get method with id: {}", id);

        return departmentMapper.entityToDto(departmentEntity);
    }

    public void updateDepartment(DepartmentRequestDto departmentRequestDto, Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("DEPARTMENT_NOT_FOUND");
        });
        BeanUtils.copyProperties(departmentRequestDto, departmentEntity, "id");
        departmentRepository.save(departmentEntity);
    }

    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new NotFoundException("DEPARTMENT_NOT_FOUND");
        }
        departmentRepository.deleteById(id);
    }
}

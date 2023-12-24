package com.example.rezarvationapp.service;

import com.example.rezarvationapp.dao.entity.AcademicDegreeEntity;
import com.example.rezarvationapp.dao.entity.DepartmentEntity;
import com.example.rezarvationapp.dao.repository.AcademicDegreeRepository;
import com.example.rezarvationapp.mapper.AcademicDegreeMapper;
import com.example.rezarvationapp.model.requestDto.AcademicDegreeRequestDto;
import com.example.rezarvationapp.model.requestDto.DepartmentRequestDto;
import com.example.rezarvationapp.model.responseDto.AcademicDegreeResponseDto;
import com.example.rezarvationapp.model.responseDto.DepartmentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AcademicDegreeService {

    private final AcademicDegreeMapper academicDegreeMapper;
    private final AcademicDegreeRepository academicDegreeRepository;

    public AcademicDegreeService(AcademicDegreeMapper academicDegreeMapper, AcademicDegreeRepository academicDegreeRepository) {
        this.academicDegreeMapper = academicDegreeMapper;
        this.academicDegreeRepository = academicDegreeRepository;
    }


    public void addAcademicDegree(AcademicDegreeRequestDto academicDegreeRequestDto){

        AcademicDegreeEntity academicDegreeEntity=academicDegreeMapper.dtoToEntity(academicDegreeRequestDto);
        academicDegreeRepository.save(academicDegreeEntity);

    }

    public List<AcademicDegreeResponseDto> getAcademicDegrees(){

        return academicDegreeMapper.entityToDtos(academicDegreeRepository.findAll());
    }
}

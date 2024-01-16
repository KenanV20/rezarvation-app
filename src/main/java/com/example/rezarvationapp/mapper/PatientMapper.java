package com.example.rezarvationapp.mapper;

import com.example.rezarvationapp.dao.entity.DepartmentEntity;
import com.example.rezarvationapp.dao.entity.PatientEntity;
import com.example.rezarvationapp.model.requestDto.PatientRequestDto;
import com.example.rezarvationapp.model.responseDto.DepartmentResponseDto;
import com.example.rezarvationapp.model.responseDto.PatientResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")


public interface PatientMapper {


    PatientEntity dtoToEntity(PatientRequestDto patientRequestDto);
    List<PatientResponseDto> entityToDtos(List<PatientEntity> departmentEntities);


    PatientResponseDto entityToDto( PatientEntity departmentEntity);
}

package com.example.rezarvationapp.mapper;

import com.example.rezarvationapp.dao.entity.PatientEntity;
import com.example.rezarvationapp.model.requestDto.PatientRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")


public interface PatientMapper {


    PatientEntity dtoToEntity(PatientRequestDto patientRequestDto);

}

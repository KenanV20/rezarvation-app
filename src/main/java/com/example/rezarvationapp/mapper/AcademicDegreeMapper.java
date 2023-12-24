package com.example.rezarvationapp.mapper;

import com.example.rezarvationapp.dao.entity.AcademicDegreeEntity;
import com.example.rezarvationapp.dao.entity.DepartmentEntity;
import com.example.rezarvationapp.model.requestDto.AcademicDegreeRequestDto;
import com.example.rezarvationapp.model.requestDto.DepartmentRequestDto;
import com.example.rezarvationapp.model.responseDto.AcademicDegreeResponseDto;
import com.example.rezarvationapp.model.responseDto.DepartmentResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface AcademicDegreeMapper {

    AcademicDegreeEntity dtoToEntity(AcademicDegreeRequestDto academicDegreeRequestDto);

    List<AcademicDegreeResponseDto> entityToDtos(List<AcademicDegreeEntity> academicDegreeEntities);


    AcademicDegreeResponseDto entityToDto( AcademicDegreeEntity academicDegreeEntity);



}

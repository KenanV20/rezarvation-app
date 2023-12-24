package com.example.rezarvationapp.mapper;

import com.example.rezarvationapp.dao.entity.DepartmentEntity;
import com.example.rezarvationapp.dao.entity.ReservationEntity;
import com.example.rezarvationapp.model.requestDto.DepartmentRequestDto;
import com.example.rezarvationapp.model.requestDto.ReservationRequestDto;
import com.example.rezarvationapp.model.responseDto.DepartmentResponseDto;
import com.example.rezarvationapp.model.responseDto.ReservationResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface DepartmentMapper {

    DepartmentEntity dtoToEntity(DepartmentRequestDto departmentRequestDto);

    List<DepartmentResponseDto> entityToDtos(List<DepartmentEntity> departmentEntities);


    DepartmentResponseDto entityToDto( DepartmentEntity departmentEntity);



}

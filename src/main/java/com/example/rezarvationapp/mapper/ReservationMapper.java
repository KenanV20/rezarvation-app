package com.example.rezarvationapp.mapper;

import com.example.rezarvationapp.dao.entity.ReservationEntity;
import com.example.rezarvationapp.model.requestDto.ReservationRequestDto;
import com.example.rezarvationapp.model.responseDto.ReservationResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "doctorEntity.id", source = "doctorId")  // Assuming you have a property named doctorId in ReservationRequestDto
    @Mapping(target = "patientEntity.id", source = "patientId")  // Assuming you have a property named patientId in ReservationRequestDto
    ReservationEntity dtoToEntity(ReservationRequestDto reservationRequestDto);

    List<ReservationEntity> dtoToEntities(List<ReservationRequestDto> reservationRequestDtos);

    @Mapping(target = "doctorId", source = "doctorEntity.id")
   @Mapping(target = "patientRes", source = "patientEntity.id")
    ReservationResponseDto entityToDto(ReservationEntity reservationEntity);

    List<ReservationResponseDto> entityToDtos(List<ReservationEntity> reservationEntities);
}

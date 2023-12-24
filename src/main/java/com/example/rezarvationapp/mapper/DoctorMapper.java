package com.example.rezarvationapp.mapper;

import com.example.rezarvationapp.dao.entity.AcademicDegreeEntity;
import com.example.rezarvationapp.dao.entity.DoctorEntity;
import com.example.rezarvationapp.model.requestDto.DoctorRequestDto;
import com.example.rezarvationapp.model.responseDto.DoctorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(source = "departmentId", target = "departmentEntity.id")
    @Mapping(target = "academicDegreeEntities", expression = "java(mapAcademicDegree(doctorRequestDto.getAcademicDegreeId()))")
    DoctorEntity dtoToEntity(DoctorRequestDto doctorRequestDto);

    List<DoctorResponseDto> entityToDtos(List<DoctorEntity> doctorEntityList);

    @Mapping(source = "departmentEntity.id", target = "departmentId")
    @Mapping(target = "academicDegreeId", expression = "java(mapAcademicDegrees(doctorEntity.getAcademicDegreeEntities()))")
    DoctorResponseDto entityToDto(DoctorEntity doctorEntity);

    default List<AcademicDegreeEntity> mapAcademicDegree(List<Long> academicDegreeIds) {
        return academicDegreeIds.stream()
                .map(id -> {
                    AcademicDegreeEntity academicDegreeEntity = new AcademicDegreeEntity();
                    academicDegreeEntity.setId(id);
                    return academicDegreeEntity;
                })
                .collect(Collectors.toList());
    }

    default List<Long> mapAcademicDegrees(List<AcademicDegreeEntity> academicDegreeEntities) {
        return academicDegreeEntities.stream()
                .map(AcademicDegreeEntity::getId)
                .collect(Collectors.toList());
    }
}

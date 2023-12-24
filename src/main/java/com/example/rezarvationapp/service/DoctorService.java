package com.example.rezarvationapp.service;

import com.example.rezarvationapp.dao.entity.AcademicDegreeEntity;
import com.example.rezarvationapp.dao.entity.DoctorEntity;
import com.example.rezarvationapp.dao.repository.DoctorRepository;
import com.example.rezarvationapp.mapper.DoctorMapper;
import com.example.rezarvationapp.model.requestDto.AcademicDegreeRequestDto;
import com.example.rezarvationapp.model.requestDto.DoctorRequestDto;
import com.example.rezarvationapp.model.responseDto.AcademicDegreeResponseDto;
import com.example.rezarvationapp.model.responseDto.DoctorResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DoctorService {

    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository) {
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
    }


    public void addDoctor(DoctorRequestDto doctorRequestDto){

        DoctorEntity doctorEntity= doctorMapper.dtoToEntity(doctorRequestDto);
        doctorRepository.save(doctorEntity);

    }

    public List<DoctorResponseDto> getDoctors(){

        return doctorMapper.entityToDtos(doctorRepository.findAll());
    }

    public DoctorResponseDto getDoctor(Long id){
        DoctorEntity doctorEntity=doctorRepository.findById(id).get();
        return doctorMapper.entityToDto(doctorEntity);
    }
}

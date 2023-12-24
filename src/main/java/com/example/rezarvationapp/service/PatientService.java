package com.example.rezarvationapp.service;

import com.example.rezarvationapp.dao.entity.PatientEntity;
import com.example.rezarvationapp.dao.entity.ReservationEntity;
import com.example.rezarvationapp.dao.repository.PatientRepository;
import com.example.rezarvationapp.mapper.PatientMapper;
import com.example.rezarvationapp.model.requestDto.PatientRequestDto;
import com.example.rezarvationapp.model.requestDto.ReservationRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper reservationMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper reservationMapper) {
        this.patientRepository = patientRepository;
        this.reservationMapper = reservationMapper;
    }


    public void addPatient(PatientRequestDto patientRequestDto){

        PatientEntity patientEntity=reservationMapper.dtoToEntity(patientRequestDto);
        patientRepository.save(patientEntity);

    }


}

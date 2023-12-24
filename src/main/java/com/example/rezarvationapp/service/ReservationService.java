package com.example.rezarvationapp.service;

import com.example.rezarvationapp.dao.entity.ReservationEntity;
import com.example.rezarvationapp.dao.repository.ReservationRepository;
import com.example.rezarvationapp.mapper.ReservationMapper;
import com.example.rezarvationapp.model.requestDto.ReservationRequestDto;
import com.example.rezarvationapp.model.responseDto.ReservationResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    public void addReservation(ReservationRequestDto reservationRequestDto){

        ReservationEntity reservationEntity=reservationMapper.dtoToEntity(reservationRequestDto);
        reservationRepository.save(reservationEntity);

    }

    public List<ReservationResponseDto> get(){

        return reservationMapper.entityToDtos(reservationRepository.findAll());
    }
}

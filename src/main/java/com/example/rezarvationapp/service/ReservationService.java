package com.example.rezarvationapp.service;

import com.example.rezarvationapp.dao.entity.ReservationEntity;
import com.example.rezarvationapp.dao.repository.ReservationRepository;
import com.example.rezarvationapp.exception.CustomerException;
import com.example.rezarvationapp.exception.NotFoundException;
import com.example.rezarvationapp.mapper.ReservationMapper;
import com.example.rezarvationapp.model.requestDto.ReservationRequestDto;
import com.example.rezarvationapp.model.responseDto.ReservationResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    public void addReservation(ReservationRequestDto reservationRequestDto) {
        log.info("ActionLog.start reservation add method");
        try {

            ReservationEntity reservationEntity = reservationMapper.dtoToEntity(reservationRequestDto);
            reservationRepository.save(reservationEntity);
        }catch (Exception ignored){
            throw  new NotFoundException(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        log.info("ActionLog.end reservation add method");
    }

    public List<ReservationResponseDto> getReservations() {
        log.info("ActionLog.start reservation get method");
        List<ReservationEntity> entities = reservationRepository.findAll();
        if (entities.isEmpty()) {
            throw new NotFoundException("Reservations_NOT_FOund");
        }
        log.info("ActionLog.end reservation get method");
        return reservationMapper.entityToDtos(reservationRepository.findAll());

    }

    public ReservationResponseDto getReservation(Long id) {
        log.info("ActionLog.start reservation get method with id: {}", id);
        ReservationEntity reservationEntity = reservationRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Reservation_NOT_FOUND");
        });
        log.info("ActionLog.end reservation get method with id: {}", id);
        return reservationMapper.entityToDto(reservationEntity);
    }

    public void updateReservation(ReservationRequestDto reservationRequestDtoto, Long id) {


        try {
            ReservationEntity reservationEntity = reservationRepository.findById(id).orElseThrow(() -> {
                throw new NotFoundException("RESERVATION_NOT_FOUND");
            });
            BeanUtils.copyProperties(reservationRequestDtoto, reservationEntity, "id");
            reservationRepository.save(reservationEntity);
        }catch (Exception ignored){
            throw  new CustomerException(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    public void deleteReservation(Long id) {

        if (!reservationRepository.existsById(id)) {
            throw new NotFoundException("RESERVATION_NOT_FOUND");
        }
        reservationRepository.deleteById(id);
    }
}

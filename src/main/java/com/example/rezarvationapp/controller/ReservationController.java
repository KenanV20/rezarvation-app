package com.example.rezarvationapp.controller;

import com.example.rezarvationapp.model.requestDto.ReservationRequestDto;
import com.example.rezarvationapp.model.responseDto.ReservationResponseDto;
import com.example.rezarvationapp.model.responseDto.SimpleMessageDto;
import com.example.rezarvationapp.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/reservation")
public class ReservationController {

    public final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public SimpleMessageDto<ReservationRequestDto> addReservation(@Valid @RequestBody ReservationRequestDto reservationRequestDto) {
        reservationService.addReservation(reservationRequestDto);
        return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED.value());
    }

    @GetMapping
    public SimpleMessageDto<List<ReservationResponseDto>> getReservations() {

        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), reservationService.getReservations());
    }

    @GetMapping("/{id}")
    public SimpleMessageDto<ReservationResponseDto> getReservation(@PathVariable Long id) {

        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), reservationService.getReservation(id));
    }

    @PutMapping("/{id}")
    public SimpleMessageDto<ReservationRequestDto> updateReservation(@PathVariable Long id, @Valid @RequestBody ReservationRequestDto reservationRequestDto) {
        reservationService.updateReservation(reservationRequestDto, id);
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
    }

    @DeleteMapping("/{id}")
    public SimpleMessageDto<String> deleteDepartment(@PathVariable Long id) {

        reservationService.deleteReservation(id);

        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
    }
}

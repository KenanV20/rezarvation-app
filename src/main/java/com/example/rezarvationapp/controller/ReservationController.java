package com.example.rezarvationapp.controller;

import com.example.rezarvationapp.model.requestDto.ReservationRequestDto;
import com.example.rezarvationapp.model.responseDto.ReservationResponseDto;
import com.example.rezarvationapp.service.ReservationService;
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
    public void addReservation(@RequestBody ReservationRequestDto reservationRequestDto) {
        reservationService.addReservation(reservationRequestDto);
    }

    @GetMapping
    public List<ReservationResponseDto> get(){

       return reservationService.get();
    }
}

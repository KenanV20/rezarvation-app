package com.example.rezarvationapp.controller;

import com.example.rezarvationapp.model.requestDto.AcademicDegreeRequestDto;
import com.example.rezarvationapp.model.requestDto.DoctorRequestDto;
import com.example.rezarvationapp.model.requestDto.ReservationRequestDto;
import com.example.rezarvationapp.model.responseDto.AcademicDegreeResponseDto;
import com.example.rezarvationapp.model.responseDto.DoctorResponseDto;
import com.example.rezarvationapp.model.responseDto.SimpleMessageDto;
import com.example.rezarvationapp.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/v1/doctor")
public class DoctorController {

    public final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping
    public void addDoctor(@Valid @RequestBody DoctorRequestDto doctorRequestDto) {
        doctorService.addDoctor(doctorRequestDto);
    }

    @GetMapping
    public SimpleMessageDto<List<DoctorResponseDto>> getDoctors() {
        return new SimpleMessageDto<>("success", HttpStatus.OK.value(),doctorService.getDoctors());
    }

    @GetMapping("/{id}")
    public SimpleMessageDto<DoctorResponseDto> getDoctor(@PathVariable Long id) {
        return new SimpleMessageDto<>("success", HttpStatus.OK.value(),doctorService.getDoctor(id));
    }
    @GetMapping("/{id}/times")
    public SimpleMessageDto<List<LocalTime>> getDoctorTimes(@PathVariable Long id) {
        return new SimpleMessageDto<>("success",HttpStatus.OK.value(),doctorService.getDoctorTimes(id));
    }
    @PutMapping("/{id}")
    public SimpleMessageDto<ReservationRequestDto> updateDoctor(@PathVariable Long id, @Valid @RequestBody DoctorRequestDto doctorRequestDto) {
        doctorService.updateDoctor(doctorRequestDto, id);
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
    }

    @DeleteMapping("/{id}")
    public SimpleMessageDto<String> deleteDepartment(@PathVariable Long id) {

        doctorService.deleteDoctor(id);

        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
    }
}

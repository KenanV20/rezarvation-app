package com.example.rezarvationapp.model.requestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationRequestDto {


    LocalDateTime appointmentDate;

    Long doctorId;

    PatientRequestDto patient;

}

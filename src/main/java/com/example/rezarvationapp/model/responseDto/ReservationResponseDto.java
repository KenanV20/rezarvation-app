package com.example.rezarvationapp.model.responseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationResponseDto {

    Long id;
    LocalDateTime appointmentDate;
    Boolean activeStatus;
    Long doctorId;
    Long patientId;

}

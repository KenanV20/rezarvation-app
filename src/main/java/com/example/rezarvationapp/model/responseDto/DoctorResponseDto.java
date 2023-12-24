package com.example.rezarvationapp.model.responseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorResponseDto {
    Long id;

    String firstName;

    String lastName;

    String phoneNumber;

    LocalTime entryTime;

    LocalTime finalTime;

    Long departmentId;

    List<Long> academicDegreeId;
}

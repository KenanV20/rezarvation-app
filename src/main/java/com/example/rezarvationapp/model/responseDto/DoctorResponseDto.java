package com.example.rezarvationapp.model.responseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
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

    Long departmentId;

    List<Long> academicDegreeId;

}

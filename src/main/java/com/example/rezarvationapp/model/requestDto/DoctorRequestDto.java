package com.example.rezarvationapp.model.requestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorRequestDto {
    String firstName;

    String lastName;

    String phoneNumber;

    LocalTime entryTime;

    LocalTime finalTime;

    Long departmentId;

    List<Long> academicDegreeId;


}

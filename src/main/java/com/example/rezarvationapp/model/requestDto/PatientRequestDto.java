package com.example.rezarvationapp.model.requestDto;

import com.example.rezarvationapp.dao.entity.enums.GenderEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientRequestDto {

    String firstName;

    String lastName;

    String phoneNumber;

    GenderEnum gender;

}

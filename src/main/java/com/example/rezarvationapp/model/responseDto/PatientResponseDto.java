package com.example.rezarvationapp.model.responseDto;

import com.example.rezarvationapp.dao.entity.enums.GenderEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientResponseDto {

    String firstName;

    String lastName;

    String phoneNumber;

    GenderEnum gender;

}

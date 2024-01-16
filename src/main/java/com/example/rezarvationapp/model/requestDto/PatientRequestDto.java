package com.example.rezarvationapp.model.requestDto;

import com.example.rezarvationapp.dao.entity.enums.GenderEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientRequestDto {
    @NotBlank(message = "Name may not be null or empty")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    String firstName;

    @NotBlank(message = "Surname may not be null or empty")
    @Size(min = 5, message = "Surname must be at least 5 characters long")
    String lastName;

    @NotBlank(message = "Phone number may not be null or empty")
    @Pattern(regexp = "^(\\+994|0)[0-9]{9}$", message = "Phone number is false")
    String phoneNumber;

    GenderEnum gender;

}

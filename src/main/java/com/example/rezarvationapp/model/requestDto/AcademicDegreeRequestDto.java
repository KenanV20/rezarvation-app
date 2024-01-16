package com.example.rezarvationapp.model.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AcademicDegreeRequestDto {

    @NotBlank(message = "Name may not be null or empty")
    @Size(min = 2 , message = "Name must be at least 2 characters long")
    String name;
}

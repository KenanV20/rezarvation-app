package com.example.rezarvationapp.controller;

import com.example.rezarvationapp.config.MyLocaleResolver;
import com.example.rezarvationapp.dao.entity.AcademicDegreeEntity;
import com.example.rezarvationapp.model.requestDto.AcademicDegreeRequestDto;
import com.example.rezarvationapp.model.requestDto.DepartmentRequestDto;
import com.example.rezarvationapp.model.responseDto.AcademicDegreeResponseDto;
import com.example.rezarvationapp.model.responseDto.DepartmentResponseDto;
import com.example.rezarvationapp.model.responseDto.SimpleMessageDto;
import com.example.rezarvationapp.service.AcademicDegreeService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.hibernate.metamodel.mapping.ordering.TranslationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.text.MessageFormat;
import java.util.List;

@RestController
@RequestMapping("/v1/academicDegree")
public class AcademicDegreeController {

    public final AcademicDegreeService academicDegreeService;

    public AcademicDegreeController(AcademicDegreeService academicDegreeService) {
        this.academicDegreeService = academicDegreeService;
    }


    @PostMapping
    public SimpleMessageDto<AcademicDegreeRequestDto> addAcademicDegree(@Valid @RequestBody AcademicDegreeRequestDto academicDegreeRequestDto) {
        academicDegreeService.addAcademicDegree(academicDegreeRequestDto);
        return new SimpleMessageDto<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED.value());
    }

    @GetMapping
    public SimpleMessageDto<List<AcademicDegreeResponseDto>> getAcademicDegrees() {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), academicDegreeService.getAcademicDegrees());
    }

    @GetMapping("{id}")
    public SimpleMessageDto<AcademicDegreeResponseDto> getAcademicDegree(@PathVariable Long id) {
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), academicDegreeService.getAcademicDegree(id));
    }


    @PutMapping("{id}")
    public SimpleMessageDto<AcademicDegreeRequestDto> updateAcademicDegree(@PathVariable Long id, @Valid @RequestBody AcademicDegreeRequestDto academicDegreeRequestDto) {
        academicDegreeService.updateAcademicDegree(academicDegreeRequestDto, id);
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
    }

    @DeleteMapping("{id}")
    public SimpleMessageDto<AcademicDegreeResponseDto> deleteAcademicDegree(@PathVariable Long id) {
        academicDegreeService.deleteAcademicDegree(id);
        return new SimpleMessageDto<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
    }
}

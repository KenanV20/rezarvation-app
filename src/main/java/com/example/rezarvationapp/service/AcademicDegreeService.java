package com.example.rezarvationapp.service;

import com.example.rezarvationapp.dao.entity.AcademicDegreeEntity;
import com.example.rezarvationapp.dao.repository.AcademicDegreeRepository;
import com.example.rezarvationapp.exception.NotFoundException;
import com.example.rezarvationapp.mapper.AcademicDegreeMapper;
import com.example.rezarvationapp.model.requestDto.AcademicDegreeRequestDto;
import com.example.rezarvationapp.model.responseDto.AcademicDegreeResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AcademicDegreeService {

    private final AcademicDegreeMapper academicDegreeMapper;
    private final AcademicDegreeRepository academicDegreeRepository;

    public AcademicDegreeService(AcademicDegreeMapper academicDegreeMapper, AcademicDegreeRepository academicDegreeRepository) {
        this.academicDegreeMapper = academicDegreeMapper;
        this.academicDegreeRepository = academicDegreeRepository;
    }


    public void addAcademicDegree(AcademicDegreeRequestDto academicDegreeRequestDto) {
        AcademicDegreeEntity academicDegreeEntity = academicDegreeMapper.dtoToEntity(academicDegreeRequestDto);
        academicDegreeRepository.save(academicDegreeEntity);
    }

    public List<AcademicDegreeResponseDto> getAcademicDegrees() {
        return academicDegreeMapper.entityToDtos(academicDegreeRepository.findAll());
    }

    public AcademicDegreeResponseDto getAcademicDegree(Long id) {
        log.info("ActionLog.start academic degree get method with id: {}", id);

        AcademicDegreeEntity academicDegreeEntity = academicDegreeRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("ACADEMIC_DEGREE_NOT_FOUND");
        });

        log.info("ActionLog.end academic degree get method with id: {}", id);

        return academicDegreeMapper.entityToDto(academicDegreeEntity);
    }
    public void updateAcademicDegree(AcademicDegreeRequestDto academicDegreeRequestDto,Long id){
        AcademicDegreeEntity academicDegreeEntity=academicDegreeRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("ACADEMIC_DEGREE_NOT_FOUND");
        });
        BeanUtils.copyProperties(academicDegreeRequestDto,academicDegreeEntity,"id");
        academicDegreeRepository.save(academicDegreeEntity);
    }

    public void deleteAcademicDegree(Long id){
       if (!academicDegreeRepository.existsById(id)){
           throw  new NotFoundException("ACADEMIC_DEGREE_NOT_FOUND");
       }
        academicDegreeRepository.deleteById(id);
    }
}

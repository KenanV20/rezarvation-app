package com.example.rezarvationapp.service;

import com.example.rezarvationapp.dao.entity.DoctorEntity;
import com.example.rezarvationapp.dao.repository.DoctorRepository;
import com.example.rezarvationapp.exception.NotFoundException;
import com.example.rezarvationapp.mapper.DoctorMapper;
import com.example.rezarvationapp.model.requestDto.DoctorRequestDto;
import com.example.rezarvationapp.model.responseDto.DoctorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DoctorService {

    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository) {
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
    }


    public void addDoctor(DoctorRequestDto doctorRequestDto) {
        log.info("ActionLog.start doctor add method ");

        DoctorEntity doctorEntity = doctorMapper.dtoToEntity(doctorRequestDto);
        doctorRepository.save(doctorEntity);

        log.info("ActionLog.end doctor add method ");
    }

    public List<DoctorResponseDto> getDoctors() {
        log.info("ActionLog.start doctor get method");

        List<DoctorEntity> doctorEntities = doctorRepository.findAll();
        if (doctorEntities.isEmpty()) {
            throw new NotFoundException("Doctor_Not_Found");
        }

        log.info("ActionLog.end doctor get method ");

        return doctorMapper.entityToDtos(doctorRepository.findAll());
    }

    public DoctorResponseDto getDoctor(Long id) {
        log.info("ActionLog.start doctor get method with id: {}", id);

        DoctorEntity doctorEntity = doctorRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Doctor_NOT_FOUND");
        });

        log.info("ActionLog.end doctor get method with id: {}", id);

        return doctorMapper.entityToDto(doctorEntity);
    }

    public void updateDoctor(DoctorRequestDto doctorRequestDto, Long id) {
        log.info("ActionLog.start doctor update method with id: {}", id);

        DoctorEntity doctorEntity = doctorRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("DOCTOR_NOT_FOUND");
        });
        BeanUtils.copyProperties(doctorRequestDto, doctorEntity, "id");
        doctorRepository.save(doctorEntity);

        log.info("ActionLog.end doctor update method with id: {}", id);
    }

    public void deleteDoctor(Long id) {
        log.info("ActionLog.start doctor delete method with id: {}", id);

        if (!doctorRepository.existsById(id)) {
            throw new NotFoundException("DOCTOR_NOT_FOUND");
        }
        doctorRepository.deleteById(id);

        log.info("ActionLog.end doctor delete method with id: {}", id);
    }

    public List<LocalTime> getDoctorTimes(Long id) {
        log.info("ActionLog.start doctor reservation times get method with id: {}", id);

        DoctorEntity doctorEntity = doctorRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Doctor_NOT_FOUND");
        });
        LocalTime entryTime = doctorEntity.getEntryTime();
        LocalTime finalTime = doctorEntity.getFinalTime();
        int interval = doctorEntity.getInterval();
        List<LocalTime> times = new ArrayList<>();
        times.add(entryTime);
        while (entryTime.plusMinutes(interval).isBefore(finalTime) || entryTime.plusMinutes(interval).equals(finalTime)) {
            entryTime = entryTime.plusMinutes(interval);
            times.add(entryTime);
        }

        log.info("ActionLog.end doctor reservation times get method with id: {}", id);

        return times;
    }

}

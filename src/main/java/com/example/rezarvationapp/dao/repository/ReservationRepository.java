package com.example.rezarvationapp.dao.repository;

import com.example.rezarvationapp.dao.entity.AcademicDegreeEntity;
import com.example.rezarvationapp.dao.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {

}

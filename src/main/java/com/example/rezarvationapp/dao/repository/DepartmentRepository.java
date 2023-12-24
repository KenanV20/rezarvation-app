package com.example.rezarvationapp.dao.repository;

import com.example.rezarvationapp.dao.entity.AcademicDegreeEntity;
import com.example.rezarvationapp.dao.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

}

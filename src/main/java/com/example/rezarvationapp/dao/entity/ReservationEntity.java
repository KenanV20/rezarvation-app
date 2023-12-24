package com.example.rezarvationapp.dao.entity;

import com.example.rezarvationapp.dao.entity.AcademicDegreeEntity;
import com.example.rezarvationapp.dao.entity.DepartmentEntity;
import com.example.rezarvationapp.dao.entity.DoctorEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(name = "rezervations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDateTime appointmentDate;

    @Builder.Default
    Boolean activeStatus=false;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="doctor_id",referencedColumnName = "id")
    DoctorEntity doctorEntity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="patient_id",referencedColumnName = "id")
    PatientEntity patientEntity;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

}

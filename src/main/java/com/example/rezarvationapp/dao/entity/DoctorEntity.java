package com.example.rezarvationapp.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity(name = "doctors")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;

    String lastName;

    String phoneNumber;

    LocalTime entryTime;

    LocalTime finalTime;

    int interval;

    @ManyToMany
    @JoinTable(name = "doctor_degree",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "degree_id"))
    List<AcademicDegreeEntity> academicDegreeEntities;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "id", name = "department_id")
    DepartmentEntity departmentEntity;

    @OneToMany(mappedBy = "doctorEntity")
    List<ReservationEntity> reservationEntity;

    @CreationTimestamp
    Date createdAt;

    @UpdateTimestamp
    Date updatedAt;

}

package com.example.demo.repo;

import com.example.demo.entitiy.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepo extends CrudRepository<Doctor, Long> {
}

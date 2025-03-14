package com.rvcode.Application.ManagementApp.repositories;

import com.rvcode.Application.ManagementApp.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
}

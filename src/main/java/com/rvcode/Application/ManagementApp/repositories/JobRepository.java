package com.rvcode.Application.ManagementApp.repositories;

import com.rvcode.Application.ManagementApp.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
}

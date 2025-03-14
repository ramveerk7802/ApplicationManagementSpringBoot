package com.rvcode.Application.ManagementApp.repositories;

import com.rvcode.Application.ManagementApp.entities.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume,Long> {
}

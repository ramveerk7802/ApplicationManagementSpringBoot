package com.rvcode.Application.ManagementApp.repositories;

import com.rvcode.Application.ManagementApp.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
}

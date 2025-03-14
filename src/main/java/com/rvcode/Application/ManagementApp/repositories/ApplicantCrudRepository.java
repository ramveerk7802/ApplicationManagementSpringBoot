package com.rvcode.Application.ManagementApp.repositories;

import com.rvcode.Application.ManagementApp.entities.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantCrudRepository extends CrudRepository<Applicant,Long> {
}

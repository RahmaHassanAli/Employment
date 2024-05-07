package com.sa_project.applicant.Repository;

import com.sa_project.applicant.Domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface JobRepository extends JpaRepository<Job, Long>{
}

package com.sa_project.applicant.Domain.dto;

import lombok.Data;
import lombok.Value;

@Value
@Data
public class JobDto {
     String position;

     String description;
    String qualification;
     long candidate_number;
     public boolean delete;
    public boolean update;
     public Long id;
}

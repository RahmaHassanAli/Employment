package com.sa_project.adminn.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
@Setter
@Getter

public class Job {
     String position;
     String description;
     String qualification;
     long candidate_number;
    public boolean delete;
    public boolean update;
    public Long id;
}

package com.sa_project.adminn.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sa_project.adminn.domain.Job;
import com.sa_project.adminn.service.admin.Admin;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service

public class AdminService {
    private final Admin admin;

    @Autowired
    public AdminService(Admin admin) {
        this.admin = admin;
    }

    public String addJob(Job job) throws JsonProcessingException{
        return admin.sendMessageForAddJob(job);
    }
    public String deleteJob(Job job) throws JsonProcessingException{
        return admin.sendMessageForDeleteJob(job);
    }
    public String updateJob(Job job) throws JsonProcessingException{
        return admin.sendMessageForUpdateJob(job);
    }

}

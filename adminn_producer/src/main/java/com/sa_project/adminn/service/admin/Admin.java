package com.sa_project.adminn.service.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa_project.adminn.domain.Job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component

public class Admin {
    @Value("${topic.name}")
    private  String jobTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String >kafkaTemplate;

    @Autowired
    public Admin(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessageForAddJob(Job job) throws JsonProcessingException{
        String jobAsMessage = objectMapper.writeValueAsString(job);
        kafkaTemplate.send(jobTopic ,jobAsMessage);
        log.info("message of adding job produced {}", jobAsMessage);
        return "message sent to add job";
    }
    public String sendMessageForDeleteJob(Job job) throws JsonProcessingException{
        String jobAsMessage = objectMapper.writeValueAsString(job);
        kafkaTemplate.send(jobTopic ,jobAsMessage);
        log.info("message of removing job produced {}", jobAsMessage);
        return "message of removing job sent";
    }
    public String sendMessageForUpdateJob(Job job) throws JsonProcessingException{
        String jobAsMessage = objectMapper.writeValueAsString(job);
        kafkaTemplate.send(jobTopic ,jobAsMessage);
        log.info("message of updating job produced {}", jobAsMessage);
        return "message message of updating job sent";
    }
}

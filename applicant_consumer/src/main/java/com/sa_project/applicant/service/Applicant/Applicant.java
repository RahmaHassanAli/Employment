package com.sa_project.applicant.service.Applicant;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa_project.applicant.Domain.dto.JobDto;
import com.sa_project.applicant.service.ApplicantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Applicant {
    private static final String jobTopic = "${topic.name}";
    final private ObjectMapper objectMapper;
    final private ApplicantService applicantService;

    @Autowired
    public Applicant(ObjectMapper objectMapper, ApplicantService applicantService) {
        this.objectMapper = objectMapper;
        this.applicantService = applicantService;
    }

    @KafkaListener(topics = jobTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);
        JobDto jobDto = objectMapper.readValue(message, JobDto.class);
        if(jobDto.delete){
            applicantService.deleteJob(jobDto.id);
        }
        else if(jobDto.update){
            applicantService.updateJob(jobDto,jobDto.id);
        }
        else{
            applicantService.addJob(jobDto);}
    }
}

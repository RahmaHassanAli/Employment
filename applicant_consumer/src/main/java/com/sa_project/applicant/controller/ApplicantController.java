package com.sa_project.applicant.controller;

import com.sa_project.applicant.Domain.Job;
import com.sa_project.applicant.service.ApplicantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        log.info("get job by id request received");
        Job job=applicantService.getJob(id);
        if(job != null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<List<Job>>getAllJobs() {
        log.info("get All jobs request received");
            return new ResponseEntity<>(applicantService.getAllJobs(), HttpStatus.OK);
    }


//    @DeleteMapping("/deleteJob/{id}")
//    public String deleteJob(@PathVariable Long id) {
//        log.info("delete job by applicant");
//        Job job=applicantService.getJob(id);
//        if(job != null){
//            return applicantService.deleteJob(id) + " deleted from the database successfully";
//        }else{
//            return "this job does not exist to be deleted!";
//        }
//    }
}

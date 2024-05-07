package com.sa_project.adminn.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sa_project.adminn.domain.Job;
import com.sa_project.adminn.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin")

public class AdminController {
    private final AdminService adminService;
    

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/publishJob")
    public String publishJob(@RequestBody Job job) throws JsonProcessingException {
        log.info("publish job request received");
        return adminService.addJob(job);
    }
    @DeleteMapping("/deleteJob/{id}")
    public String deleteJob(@RequestBody Job job,@PathVariable Long id) throws JsonProcessingException {
        log.info("delete job request received");
        job.setDelete(true);
        job.setId(id);
        return adminService.deleteJob(job);
    }
    @PutMapping("/updateJob/{id}")
    public String updateJob(@RequestBody Job job,@PathVariable Long id) throws JsonProcessingException {
        log.info("update job request received");
        job.setUpdate(true);
        job.setId(id);
        return adminService.updateJob(job);
    }
}

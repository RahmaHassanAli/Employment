package com.sa_project.applicant.service;

import com.sa_project.applicant.Domain.Job;
import com.sa_project.applicant.Domain.dto.JobDto;
import com.sa_project.applicant.Repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class ApplicantService {
    private final JobRepository jobRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public ApplicantService(JobRepository jobRepo,ModelMapper modelMapper) {
        this.modelMapper=modelMapper;
        this.jobRepo = jobRepo;
    }
    public void addJob(JobDto jobDto){
        Job job =modelMapper.map(jobDto,Job.class);
        Job addedJob=jobRepo.save(job);
        log.info("job added  {}",addedJob);
    }
    public Job getJob(Long id) {
        Optional<Job> job = jobRepo.findById(id);
        log.info("find a job {}",job);
        return job.orElse(null);
    }
    public List<Job> getAllJobs() {
        List<Job> jobs = jobRepo.findAll();
        log.info("find all jobs  {}",jobs);
        return jobs;
    }

    public void deleteJob(Long id) {
        Job job = this.getJob(id);
        if (job != null) {
            jobRepo.deleteById(id);
            log.info("job deleted  {}", jobRepo.findById(id));
        } else {
            log.info("this job does not exist to be deleted!");
        }
    }
    public Job updateJob(JobDto updatedJob, Long id) {
        Optional<Job> oldJob = jobRepo.findById(id);
        if (oldJob.isPresent()) {
            Job job = oldJob.get();
            job.setId(updatedJob.getId());
            job.setCandidate_number(updatedJob.getCandidate_number());
            job.setDescription(updatedJob.getDescription());
            job.setPosition(updatedJob.getPosition());
            job.setQualification(updatedJob.getQualification());
            log.info("job updated  {}", jobRepo.findById(id));
            return jobRepo.save(job);
        } else{
            log.info("this job does not exist to be updated!");
            return null;}

    }
}








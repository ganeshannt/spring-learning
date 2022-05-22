package com.ganeshannt.batch.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class LoadController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @GetMapping("/load")
    public BatchStatus loadUserData() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        Map<String, JobParameter> map = new HashMap<>();
        map.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(map);
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);

        System.out.println("Job execution: " + jobExecution.getStatus());

        System.out.println("Batch is running ...");
        while (jobExecution.isRunning()) {
            System.out.println("................");
        }
        return jobExecution.getStatus();
    }
}

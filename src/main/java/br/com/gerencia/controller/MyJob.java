package br.com.gerencia.controller;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Logic here........");
    }
    
}
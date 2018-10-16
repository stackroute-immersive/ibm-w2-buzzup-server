package com.stackroute.buzzup.showsheduler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.stackroute.buzzup.showsheduler.job.JobFunction;

@SpringBootApplication
@EnableScheduling
public class ShowShedulerApplication {

	public static void main(String[] args) throws SchedulerException, IOException, ParseException {

		SpringApplication.run(ShowShedulerApplication.class, args);

	}

}

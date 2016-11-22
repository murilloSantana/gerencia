package gerencia;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Teste {
	public static void main(String[] args) {
		 try {
	           SchedulerFactory schedFact = new StdSchedulerFactory();
	           Scheduler sched = schedFact.getScheduler();
	           sched.start();
	           JobDetail job = JobBuilder.newJob(MyJob.class)
	               .withIdentity("myJob", "group1")
	               .build();
	           Trigger trigger = TriggerBuilder
	               .newTrigger()
	               .withIdentity("myTrigger", "group1")
	               .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ? "))
	               .build();
//	               .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//                          .withIntervalInSeconds(30)
//                          .repeatForever()).build();
	               
	            sched.scheduleJob(job, trigger);
	       } catch (Exception e) {
	           System.out.println("erro");
	           e.printStackTrace();
	       }
	}
	  
}

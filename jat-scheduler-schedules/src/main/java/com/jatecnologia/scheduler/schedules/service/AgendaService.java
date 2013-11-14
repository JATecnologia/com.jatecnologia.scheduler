package com.jatecnologia.scheduler.schedules.service;


import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgendaService implements ServletContextListener{

	private static Logger logger = LoggerFactory.getLogger(AgendaService.class);
	
	public static Scheduler scheduler;
	
	protected void init() throws ObjectAlreadyExistsException {
		try {
			StdSchedulerFactory schedFactory = new StdSchedulerFactory();

			logger.info("***** Create scheduler");
			AgendaService.scheduler = schedFactory.getScheduler();

			logger.info("***** Starting jobs");
			
			logger.info("***** job: 01");			
			 
			//   JobDetail jobHora = new JobDetail("JobIntegraBysoft",Scheduler.DEFAULT_GROUP, JobHora.class);

//			   getLog().info("---------------- Criar Gatilho Job Hora  ----------------");
//			   SimpleTrigger sptJobHora = new SimpleTrigger(
//			     "JobHora", sched.DEFAULT_GROUP, new Date(), null,
//			     SimpleTrigger.REPEAT_INDEFINITELY, 3600L * 1000L);
//
//			   getLog().info("---------------- Faz o Agendamento de JobHora ----------------");
//			   java.util.Date ft = sched.scheduleJob(jobHora, sptJobHora);
//
//			   /* Imprime informações do Job */
//			   getLog().info(jobHora.getFullName() + " Foi programado para funcionar em: "
//			     + ft + " e repete baseado na expressão: ");
//			   /* ************************ Fim Job Hora *******************************/


//			   /* ************************ Inicio Job Dia *****************************/
//			   getLog().info("---------------- Criando tarefa: JobDia para ser executado todos os dias as 22 horas ----------------");
//			   JobDetail JobDia = new JobDetail("JobDia",Scheduler.DEFAULT_GROUP,
//			      JobDia.class);
//
//			   getLog().info("---------------- Criar Gatilho Para JobDia  ----------------");
//			   CronTrigger ctgJobDia = new CronTrigger("JobDia", sched.DEFAULT_GROUP);
//			   /* setCronExpression(* Segundos,* Minutos,* Horas,* Dias do mês,* Mês,* Dias da semana) */
//			   ctgJobDia.setCronExpression("0 00 22 * * ?");
//
//			   getLog().info("---------------- Faz Agendamento de JobDia ----------------");
//			   java.util.Date dataAniversariosDoDia = sched.scheduleJob(JobDia, ctgJobDia);
//
//			   /* Imprime informações do Job */
//			   getLog().info(JobDia.getFullName() + " Foi programado para funcionar em: "
//			     + dataAniversariosDoDia + " e repete baseado na expressão: "); 
//			   /* ************************ Fim Job Dia **************************** */
//

			   /* Iniciar execução do Scheduler */
			   AgendaService.scheduler.start();   


			  } catch (Exception e) {
			   System.out.println("\n\nErro ao tentar iniciar Scheduler .\n\n");
			   e.printStackTrace();
			  }
	}
	
	public void restart() {
		try {
			AgendaService.scheduler.shutdown(true);
		}catch (Exception ex) {
			logger.error("Error restart the tasks");
			logger.error(ex.getMessage(), ex);
		}		
	 }
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try{
			init();
		}catch (Exception ex) {
		ex.getStackTrace();
		}		
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		restart();		
	}

	

}

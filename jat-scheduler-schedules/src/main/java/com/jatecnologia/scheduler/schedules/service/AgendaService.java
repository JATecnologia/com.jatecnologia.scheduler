package com.jatecnologia.scheduler.schedules.service;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgendaService implements ServletContextListener{

	private static Logger logger = LoggerFactory.getLogger(AgendaService.class);
	
	public static Scheduler scheduler;
	
	protected void init() throws ObjectAlreadyExistsException {

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

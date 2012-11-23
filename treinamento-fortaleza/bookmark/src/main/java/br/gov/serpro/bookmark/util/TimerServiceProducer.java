package br.gov.serpro.bookmark.util;

import javax.annotation.Resource;
import javax.ejb.TimerService;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@RequestScoped
public class TimerServiceProducer {
	
	@Resource
	private TimerService timerService;
	
	@Produces
	public TimerService createTimerService(final InjectionPoint ip){
		return timerService;
	}

}

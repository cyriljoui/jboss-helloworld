package com.cjo.jee.interceptors;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import com.cjo.jee.services.DataBaseUserRepository;
import com.cjo.jee.services.Database;
import com.cjo.jee.services.IRepository;
import com.cjo.jee.services.InMemoryUserRepository;

@ApplicationScoped
public class Factory {

	@Produces
	public IRepository repository() {
		if ("database".equals(System.getenv("app.config"))) {
			return new DataBaseUserRepository("admin", "pwd");
		} else {
			InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
			inMemoryUserRepository.init();
			return inMemoryUserRepository;
		}
	}
	
	@Produces
	@Database
	public IRepository database() {
		return new DataBaseUserRepository("admin", "pwd");
	}
	
	
	@Produces
	public Logger log(InjectionPoint ip) {
		return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
	}
}
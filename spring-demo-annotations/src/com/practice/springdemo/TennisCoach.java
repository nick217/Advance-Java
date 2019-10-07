package com.practice.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("myCoach")
@Component // this will now use the default bean-id.
//@Scope("prototype") //Make the bean scope as prototype. 
					//@PreDestroy function will not be called for prototype scope.
public class TennisCoach implements Coach {

	@Autowired // field Injection
	@Qualifier("happyFortuneService") // for resolving conflict among various
										// implementations of FortuneSercie
	private FortuneService fortuneService;

	// add default constructor
	public TennisCoach() {
		System.out.println(">> Tennis Coach: Inside default constructor");
	}
	/*
	 * @Autowired // constructor Injection public TennisCoach(FortuneService fS)
	 * { fortuneService = fS; }
	 */

	/*
	 * // add setter method
	 * 
	 * @Autowired // setter Injection public void
	 * setFortuneService(FortuneService fS) {
	 * System.out.println(">> TennisCoach: Inside setFortuneService()");
	 * fortuneService = fS; }
	 */

	/*
	 * @Autowired // field Injection public void doSomeStuff(FortuneService fS)
	 * { System.out.println(">> TennisCoach: Inside setFortuneService()");
	 * fortuneService = fS; }
	 */

	@PostConstruct
	public void createMyStuff(){
		System.out.println(">> TennisCoach: Inside @PostConstruct annotated function");
	}
	
	@PreDestroy
	public void destroyMyStuff(){
		System.out.println(">> TennisCoach: Inside @PreDestroy annotated function");
	}
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

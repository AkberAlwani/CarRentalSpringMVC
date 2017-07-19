package cs544.carrental.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllersAdvise {
	
	Logger log = Logger.getLogger(getClass());
	@Before("execution(* cs544.carrental.service..*(..))")
	public void beforeCall(JoinPoint jp)
	{
		System.out.println("AOP before execution loging");
		log.info("A call is about to process");
		Object[] args = jp.getArgs();
		log.info("Arguments are:");
		for(Object arg:args)
		{
			log.info(arg);
		}
		
	    System.out.println();
	    System.out.println( "   **********     TARGET CLASS : " + 
		jp.getSignature().getDeclaringTypeName() + "." +
		jp.getSignature().getName() + 
			    			"    **********");
	}
	
	@After("execution(* cs544.carrental.service..*(..))")
	public void afterCall(JoinPoint jp)
	{
		log.info("A call is processed");
		Object[] args = jp.getArgs();
		log.info("Arguments are:");
		for(Object arg:args)
		{
			log.info(arg);
		}
	}
}

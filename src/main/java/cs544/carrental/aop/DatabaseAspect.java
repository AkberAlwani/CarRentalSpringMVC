package cs544.carrental.aop;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import cs544.carrental.domain.Customer;
import cs544.carrental.domain.Reservation;
import cs544.carrental.emailservice.EmailService;
import cs544.carrental.log.LogWriter;


@Aspect
public class DatabaseAspect {
	
	@Autowired
	private LogWriter logWriter;
	
	@Autowired
	private EmailService emailService;
	
	@Around("execution(* cs544.carrental.dao..*.*(..))")
	public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		Object obj = joinPoint.proceed();
		sw.stop();
		String message = "Function call: " + joinPoint.getTarget().getClass().getName() + "." 
				+ joinPoint.getSignature().getName() + " took " + " " + sw.getLastTaskTimeMillis() + "ms";
		logWriter.writeInfoLog(message);
		return obj;
	}
	
	@Before("execution(* cs544.carrental.ReservationService.*(..))")
	public void beforeAnyMethodSupplier(JoinPoint jp){
		System.out.println("before reservation controller method executed:"+jp.getSignature());
	}
	
	@After("execution(* cs544.carrental.ReservationController.add(..))")

	public void afterPlaceaorder(JoinPoint jp) throws IOException{
		Customer cust = (Customer) jp.getArgs()[0];
		HttpServletRequest request = (HttpServletRequest) jp.getArgs()[1];
		HttpSession session = request.getSession();
		
		Reservation cart = (Reservation ) session.getAttribute("order");
		String msg="Dear "+cust.getFirstName()+" "+cust.getLastName()+", <br>";
		msg+="<ul>";
			msg+="<li>"+cart.getVehicle().getMake() +"-"+cart.getVehicle().getModel()+"-"+cart.getVehicle().getMakeyear()+" has been Booked"+"</li>";
			msg+="<li> Order From "+cart.getPickUpDateTime()+" To " + cart.getReservationDateTime()+"/<li>"; 
		msg+="</ul>";
		msg+="Total Price : $"+cart.getPricePerDay();
		
		
		emailService.sendMail("admin@4dots.com", cust.getEmail(), "Your Booking Has been Confirmed", msg,new Locale("en"));
		
//		emailService.sendMail("aali@mum.edu;boliu@mum.edu", user.getEmail(), "Your New Orders", msg);
		String message = "Email send to "+cust.getFirstName()+" "+cust.getEmail();
		logWriter.writeInfoLog(message);
		//System.out.println();
	}
}

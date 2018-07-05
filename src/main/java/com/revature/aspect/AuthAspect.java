package com.revature.aspect;




import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.revature.beans.Login;
import com.revature.exceptions.UnauthorizedException;

@Component
@Aspect
@Order(10)
public class AuthAspect {
	private static Logger log = Logger.getLogger(HibernateAspect.class.toString());
	@Autowired
	HttpSession httpsession;
	
	public AuthAspect () {
		log.trace("created a authaspect");
	}
	// make sure we are logged in or return unauthorized errors.
	@Around("routedFunctions()") 
	public Object forceLogin(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		Login user = (Login) httpsession.getAttribute("currentUser");
		if(user == null) {
			throw new UnauthorizedException();
		} else {			
			obj = pjp.proceed();
		}
		return obj;
	}
	
	@Pointcut("execution(* com.revature.controller..*(..)) && !execution(* com.revature.controller.LoginController..*(..))") // && !execution(* com.revature.controller.ErrorController.*(..))
	public void routedFunctions() { /* hook function */ } // could probably be remvoved if we only have the one forceLogin.
}

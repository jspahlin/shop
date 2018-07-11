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

import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.Login;
import com.revature.exceptions.UnauthorizedException;

/** Check that a user is at the correct role leve. This assumes that the user has a valid session object.
 * @author jspah
 *
 */
@Component
@Aspect
@Order(20)
public class AuthRoleAspect {
	private static Logger log = Logger.getLogger(HibernateAspect.class.toString());
	private static final String CURRENT_USER = "currentUser";
	@Autowired
	HttpSession httpSession;
	
	public AuthRoleAspect () {
		log.trace("created a authaspect");
	}
	
	@Around("adminRoutedFunctions()")
	public Object forceAdminLogin(ProceedingJoinPoint pjp) throws Throwable { // NOSONAR
		Object obj = null;
		Login user = (Login) httpSession.getAttribute(CURRENT_USER);
		if(user instanceof Admin) {
			obj = pjp.proceed();
		} else {			
			throw new UnauthorizedException();
		}
		return obj;
	}
	
	@Around("employeeRoutedFunctions()")
	public Object forceEmployeeLogin(ProceedingJoinPoint pjp) throws Throwable { // NOSONAR
		Object obj = null;
		Login user = (Login) httpSession.getAttribute(CURRENT_USER);
		if(user instanceof Employee) {
			obj = pjp.proceed();
		} else {			
			throw new UnauthorizedException();
		}
		return obj;
	}
	
	@Around("customerRoutedFunctions()")
	public Object forceCustomerLogin(ProceedingJoinPoint pjp) throws Throwable { // NOSONAR
		Object obj = null;
		Login user = (Login) httpSession.getAttribute(CURRENT_USER);
		if(user instanceof Customer) {
			obj = pjp.proceed();
		} else {			
			throw new UnauthorizedException();
		}
		return obj;
	}

	@Pointcut("execution(* com.revature.controller.*.admin*(..))")
	public void adminRoutedFunctions() { /* hook function */ }
	
	@Pointcut("execution(* com.revature.controller.*.customer*(..))")
	public void customerRoutedFunctions() { /* hook function */ }
	
	@Pointcut("execution(* com.revature.controller.*.employee*(..))")
	public void employeeRoutedFunctions() { /* hook function */ }
}

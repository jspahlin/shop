package com.revature.aspect;



import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.revature.data.HibernateSession;
import com.revature.utils.HibernateUtil;

@Component
@Aspect
@Order(100)
public class HibernateAspect {
        @Autowired
        private HibernateUtil hu;

        private static Logger log = Logger.getLogger(HibernateAspect.class.toString());
        public HibernateAspect() {
        	log.trace("Created a HibernateAspect!");
        }
        @Around("allDaoObject()")
        public Object manageSession(ProceedingJoinPoint pjp) throws Throwable {
                Object obj = null;

				synchronized (this) {
                Session session = hu.getSession();
                Transaction tx = session.beginTransaction();
                HibernateSession hs = (HibernateSession) pjp.getThis();
                hs.setSession(session);
                try {
                        obj = pjp.proceed();
                        log.info(pjp.getClass().getName());
                        log.info("flushing...");
                        session.flush();
                } catch (PersistenceException e) {
                	tx.rollback();
                	session.close();
                	hs.setSession(null);
                	return null;
                } catch (Error|Exception e) {
                        tx.rollback();
                        session.close();
                        hs.setSession(null);
                        throw e;
                }
                tx.commit();
                session.close();
                hs.setSession(null);
                }
                return obj;
        }

        @Pointcut("execution(* com.revature.data..*(..)) && !execution(* com.revature.data..setSession(..))")
        public void allDaoObject() { /* hook function */ }
}

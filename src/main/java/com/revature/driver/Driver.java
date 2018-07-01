package com.revature.driver;

import org.hibernate.Session;

import com.revature.beans.CardType;
import com.revature.utils.HibernateUtil;

public class Driver {
	//private static Logger log = Logger.getLogger(Driver.class);
    private static HibernateUtil hu = HibernateUtil.getInstance();
    

	public static void main (String[] args) {
		//log.error("test");
		System.out.println("hi");
		
		Session sess = hu.getSession();
		CardType cardType = new CardType(1, "Creature");
		
		sess.save(cardType);
		
		sess.close();
		hu.getSessionFactory().close();
		
		System.out.println("ended?");
	}
}

package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml") 
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();
        
        try {           
            // create the objects
        	Instructor tempInstructor = new Instructor("wei", "wei", "wei@gmail.com");
        	
        	InstructorDetail  tempInstructorDetail = new InstructorDetail("http:wwwgsdfsdfsdf","my hobby is ...");
        	
        	tempInstructor.setInstructorDetail(tempInstructorDetail);
        	
            
            // start a transaction
        	System.out.println("Saving instructor: "+ tempInstructor);
            session.beginTransaction();
            
            // save the instructor
            session.save(tempInstructor);
            
            
            // commit transaction
            session.getTransaction().commit(); 
            
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
	}

}

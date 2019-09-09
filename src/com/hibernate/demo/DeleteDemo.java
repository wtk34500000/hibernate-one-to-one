package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
            
            session.beginTransaction();
            
            int id = 1;
            
            //get the instructor by id
            Instructor tempInstructor = session.get(Instructor.class, id);
            
            //delete the instructor
            if(tempInstructor != null) {
            	session.delete(tempInstructor);
            }
            
            // commit transaction
            session.getTransaction().commit(); 
            
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
	}

}

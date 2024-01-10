package com.hibernate.cache.Level_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{


//		Student std=new Student();
//		std.setsId(1);
//		std.setsName("MANJU");
//		std.setsMarks(100);
//
//		Student std1=new Student();
//		std1.setsId(2);
//		std1.setsName("HANSA");
//		std1.setsMarks(200);
//
//		Student std2=new Student();
//		std2.setsId(3);
//		std2.setsName("AKASH");
//		std2.setsMarks(300);

		Configuration configuration=new Configuration().addAnnotatedClass(Student.class).configure();
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();

//		session.save(std);
//		session.save(std1);
//		session.save(std2);		
		
		
		//client-1 same data and different data
		
		System.out.println("*****************Client_1**********Session_SAME_details***********");
		System.out.println();
		Student student=session.load(Student.class, 1);
		System.out.println(student);
		
		Student student2=session.load(Student.class, 1);
		System.out.println(student2);
		System.out.println();
		System.out.println("******************************************************************");
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("*************Client_1***********Session_DIFFERENT_details************");
		System.out.println();
		Student student3=session.load(Student.class, 2);
		System.out.println(student3);
		Student student4=session.load(Student.class, 2);
		System.out.println(student4);
		System.out.println("******************************************************************");
		
		System.out.println();
		System.out.println();
		
		// client-2 
		
		System.out.println("*************Client_2*****************Session_SAME_details******");
		System.out.println();
		
		Session session1=factory.openSession();
		Transaction trans1=session1.beginTransaction();
		
		Student stdc2=session1.load(Student.class, 2);
		System.out.println(stdc2);
		
		Student stdc3=session1.load(Student.class, 2);
		System.out.println(stdc3);
		
		Student stdc4=session1.load(Student.class, 1);
		System.out.println(stdc4);
	
		
		trans1.commit();
		session1.close();
		
		trans.commit();
		session.close();


	}
}

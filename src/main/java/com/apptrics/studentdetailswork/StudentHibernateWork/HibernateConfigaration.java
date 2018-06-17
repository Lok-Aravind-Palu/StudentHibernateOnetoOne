package com.apptrics.studentdetailswork.StudentHibernateWork;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

public class HibernateConfigaration {

	public static SessionFactory sessionfactory;
	public static Session session;
	static Scanner s = new Scanner(System.in);
	static StudentDetails sd = new StudentDetails();
	static Marks m = new Marks();

	@SuppressWarnings("deprecation")
	public static void connectDB() {
		Configuration configure = new Configuration().configure("HibernateConfigaration.cfg.xml");
		sessionfactory = configure.buildSessionFactory();
		System.out.println("Connected to the DataBase");
	}

	public static void insertValues() {
		System.out.println("Enter the name of the student ");
		String name = s.next();
		System.out.println("Enter the student id ");
		int id = s.nextInt();
		System.out.println("Enter the marks of 4 subjects ");
		double m1 = s.nextDouble();
		double m2 = s.nextDouble();
		double m3 = s.nextDouble();
		double m4 = s.nextDouble();

		sd.setsName(name);
		sd.setsId(id);
		m.setId(1);
		m.setM1(m1);
		m.setM2(m2);
		m.setM3(m3);
		m.setM4(m4);
		sd.setMarks(m);

		try {
			session = sessionfactory.openSession();
			

			Transaction transaction = session.getTransaction();
			
			transaction.begin();
			session.save(m);
			session.save(sd);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	public static void updateDetails() {
		System.out.println("Enter the name of the student ");
		String name = s.next();
		System.out.println("Enter the student id ");
		int id = s.nextInt();
		System.out.println("Enter the marks of 4 subjects ");
		int m1 = s.nextInt();
		int m2 = s.nextInt();
		int m3 = s.nextInt();
		int m4 = s.nextInt();

		try {
			session = sessionfactory.openSession();

			StudentDetails sds = (StudentDetails) session.get(StudentDetails.class, id);
			if (sds != null) {
				sds.setsName(name);
				m.setM1(m1);
				m.setM2(m2);
				m.setM3(m3);
				m.setM4(m4);
			}
			session.save(sds);

			Transaction transaction = session.beginTransaction();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void readTable() {

		session = sessionfactory.openSession();

		Criteria createCriteria = session.createCriteria(StudentDetails.class);
		List list = createCriteria.list();
		list.forEach((student) -> {
			System.out.println(student.toString());
		});
	}

	public static void readFromTable() {

		System.out.println("Enter the id of the student you need the details of :");
		int id = s.nextInt();
		System.out.println("Enter the name of the student you need the details of :");
		String name = s.next();

		session = sessionfactory.openSession();

		Criteria createCriteria = session.createCriteria(StudentDetails.class);

		SimpleExpression eq = Restrictions.eq("sName", name);
		SimpleExpression eq1 = Restrictions.eq("sId", id);
		LogicalExpression lo = Restrictions.and(eq, eq1);

		createCriteria.add(lo);
		List list = createCriteria.list();
		list.forEach((student) -> {
			System.out.println(student.toString());
		});

	}

	public static void deleteFromTable() {
		System.out.println("Enter the id of the student you want to delete");
		int id = s.nextInt();

		try {
			session = sessionfactory.openSession();
			StudentDetails sds = (StudentDetails) session.get(StudentDetails.class, id);
			session.delete(sds);

			Transaction transaction = session.beginTransaction();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void deleteTable() {
		try {
			session = sessionfactory.openSession();
			Query createQuery = session.createSQLQuery("drop table StudentTB");
			createQuery.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeSessionFactory() {
		sessionfactory.close();
	}

}

package com.kevin.app;

import com.kevin.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App1Simple {
    public static void main(String[] args) {

        //creating configuration object
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

        //creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();

        //creating session object
        Session session = factory.openSession();

        //creating transaction object
        Transaction t = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setId(100);
        e1.setFirstName("Max");
        e1.setLastName("Su");

        //persisting the object
        session.persist(e1);

        //transaction is committed
        t.commit();
        session.close();

        System.out.println("successfully saved");
    }
}

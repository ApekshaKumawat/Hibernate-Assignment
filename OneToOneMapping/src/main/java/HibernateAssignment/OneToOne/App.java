package HibernateAssignment.OneToOne;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import HibernateAssignment.OneToOne.configuration.HibernateUtils;
import HibernateAssignment.OneToOne.entity.ContactInfo;
import HibernateAssignment.OneToOne.entity.Freelancer;

public class App {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Freelancer freelancer1 = new Freelancer();
            freelancer1.setFreelancerName("Apeksha");
            freelancer1.setSpecialization("Java");

            ContactInfo contact1 = new ContactInfo();
            contact1.setEmail("ak@gmail.com");
            contact1.setPhoneNo("1000000000");

            freelancer1.setContactInfo(contact1);
            contact1.setFreelancer(freelancer1);

            session.persist(contact1);
            session.persist(freelancer1);
            session.getTransaction().commit();

            Query<Freelancer> employeeQuery = session.createQuery("from Freelancer", Freelancer.class);
            List<Freelancer> freelancers = employeeQuery.getResultList();
            for (Freelancer f : freelancers) {
                System.out.println("Name: " + f.getFreelancerName() + ", Email: " + f.getContactInfo().getEmail() + ", PhoneNo: " + f.getContactInfo().getPhoneNo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

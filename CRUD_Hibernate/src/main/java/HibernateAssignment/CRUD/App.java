package HibernateAssignment.CRUD;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import HibernateAssignment.CRUD.configuration.HibernateUtils;
import HibernateAssignment.CRUD.entity.EmpName;
import HibernateAssignment.CRUD.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	//Created two employees
    	EmpName name1 = new EmpName();
    	name1.setfName("Ms");
    	name1.setmName("Apeksha");
    	name1.setlName("Kumawat");
    	Employee emp1 = new Employee();
    	emp1.setEmpEmail("apeksha@gmail.com");
    	emp1.setEmpName(name1);
    	
    	
    	EmpName name2 = new EmpName();
    	name2.setfName("Subhash");
    	name2.setmName("Chandra");
    	name2.setlName("Kumawat");
    	Employee emp2 = new Employee();
    	emp2.setEmpEmail("sck@gmail.com");
    	emp2.setEmpName(name2);
    	
    	
    	EmpName name3 = new EmpName();
    	name3.setfName("first");
    	name3.setmName("middle");
    	name3.setlName("last");
    	Employee emp3 = new Employee();
    	emp3.setEmpEmail("mailId@gmail.com");
    	emp3.setEmpName(name3);
    	
    	    	
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        System.out.println("CREATE");
        //Saved the data of employees in in-memory database
        session.persist(emp1);
        session.persist(emp2);
        session.persist(emp3);
        session.createQuery("from Employee ",Employee.class).list().forEach(System.out::println);
        
        
        System.out.println("UPDATE");
        //updating the email id of emp1
        emp1.setEmpEmail("ak@gmail.com");
        session.merge(emp1);
        session.createQuery("from Employee ",Employee.class).list().forEach(System.out::println);
        
        System.out.println("DELETE 3rd Employee");
        //Deleted the third temporary employee
        session.remove(emp3);
        
        //Reading the data after deletion
        session.createQuery("from Employee ",Employee.class).list().forEach(System.out::println);
        
        //retrieving using list
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> emp = query.getResultList();
        for (Employee e : emp) {
             System.out.println("Name: " +e.getEmpName()+
            		  			"Email: "+e.getEmpEmail());
		
        }
        session.getTransaction().commit();
        session.close();
    }
}

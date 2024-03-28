package HibernateAssignment.ManyToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import HibernateAssignment.ManyToManyMapping.configuration.HibernateUtils;
import HibernateAssignment.ManyToManyMapping.entity.Club;
import HibernateAssignment.ManyToManyMapping.entity.Student;

public class App 
{
	public static void printDetails(Session session,Long... ids) {
		for(Long id : ids) {
			Student student = session.get(Student.class, id);
			System.out.print("Student : "+ student.getName()+
							 "Clubs :" + student.getClubs());
			Club club = session.get(Club.class, id);
			System.out.print("Club : "+ student.getName()+
							 "Students :" + club.getStudents());
		}
		
	}
	
    public static void main( String[] args )
    {
    	 try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
                 Session session = sessionFactory.openSession()) {
                session.beginTransaction();

               Student student1 = new Student();
               student1.setName("st1");
               student1.setEmail("st1@gmail.com");
               student1.setCourse("MCA");
               
               Student student2 = new Student();
               student1.setName("st2");
               student1.setEmail("st2@gmail.com");
               student1.setCourse("Btech");
               
               Club club1 = new Club();
               club1.setClubName("DataZScale");
               club1.setCategory("Data Science");
               club1.setPresidentName("Ms. Sharma");
               
               Club club2 = new Club();
               club1.setClubName("Qureka");
               club1.setCategory("Quiz");
               club1.setPresidentName("AK");
           
               
//               List<Student> students = new ArrayList<>();
//               students.add(student1);
//               students.add(student2);
//               
//               List<Club> StudentClub1 = new ArrayList<>();
//               StudentClub1.add(club1);
//               StudentClub1.add(club2);
//               
//               student1.setClubs(StudentClub1);
//               
//               List<Club> StudentClub2 = new ArrayList<>();
//               StudentClub2.add(club1);
//               student2.setClubs(StudentClub2);
               
               student1.joinClub(club1);
               student1.joinClub(club2);
               student2.joinClub(club2);

               session.persist(student1);
               session.persist(student2);
               session.persist(club1);
               session.persist(club2);
               session.getTransaction().commit();
               
               printDetails(session,student1.getId(), student2.getId(), club1.getId(), club2.getId());
               
               
                
            } catch (Exception e) {
                e.printStackTrace();
        }
    }
}

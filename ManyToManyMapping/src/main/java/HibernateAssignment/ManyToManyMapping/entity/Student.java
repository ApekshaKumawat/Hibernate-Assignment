package HibernateAssignment.ManyToManyMapping.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String name;
	@NotNull
	private String course;
	@Email
	private String email;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name="student_club", joinColumns= @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name="club_id"))
	private List<Club> clubs = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public List<Club> getClubs() {
		return clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}


	public Student(long id, @NotNull String name, @NotNull String course, @Email String email) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.email = email;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	public void joinClub(Club club) {
		clubs.add(club);
		club.getStudents().add(this);
	}

	
	
}

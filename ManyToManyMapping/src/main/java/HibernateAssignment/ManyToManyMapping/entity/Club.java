package HibernateAssignment.ManyToManyMapping.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="club")
public class Club {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="club_id")
	private long id;
	
	@NotNull
	@Column(name="club_name")
	private String clubName;
	
	@NotNull
	@Column(name="president_name")
	private String presidentName;
	
	@NotNull
	@Column(name="category")
	private String category;
	
	@ManyToMany(mappedBy="clubs")
	private List<Student> students = new ArrayList<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getPresidentName() {
		return presidentName;
	}
	public void setPresidentName(String presidentName) {
		this.presidentName = presidentName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Club() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Club(long id, @NotNull String clubName, @NotNull String presidentName, @NotNull String category) {
		super();
		this.id = id;
		this.clubName = clubName;
		this.presidentName = presidentName;
		this.category = category;
	}
	
}

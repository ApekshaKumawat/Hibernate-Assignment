package HibernateAssignment.OneToOne.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Contact")
public class ContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	@Size(min=10,max=10)
	private String phoneNo;

	
	@OneToOne(mappedBy = "contactInfo", cascade = CascadeType.ALL)
	private Freelancer freelancer;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public Freelancer getFreelancer() {
		return freelancer;
	}


	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}


	public ContactInfo(long id, @Email @NotNull String email, @NotNull String phoneNo, Freelancer freelancer) {
		super();
		this.id = id;
		this.email = email;
		this.phoneNo = phoneNo;
		this.freelancer = freelancer;
	}


	public ContactInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "ContactInfo [id=" + id + ", email=" + email + ", phoneNo=" + phoneNo + ", freelancer=" + freelancer
				+ "]";
	}





	
}

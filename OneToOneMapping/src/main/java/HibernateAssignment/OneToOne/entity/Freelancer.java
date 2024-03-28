package HibernateAssignment.OneToOne.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Freelancer")
public class Freelancer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long freelancerId;
	@NotNull
	private String freelancerName;
	private String specialization;
	
	@OneToOne
	private ContactInfo contactInfo;

	public long getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(long freelancerId) {
		this.freelancerId = freelancerId;
	}

	public String getFreelancerName() {
		return freelancerName;
	}

	public void setFreelancerName(String freelancerName) {
		this.freelancerName = freelancerName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Freelancer(int freelancerId, String freelancerName, ContactInfo contactInfo) {
		super();
		this.freelancerId = freelancerId;
		this.freelancerName = freelancerName;
		this.contactInfo = contactInfo;
	}

	public Freelancer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

	

}

package HibernateAssignment.OneToManyMapping.entity;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String name;
	@NotNull
	private String industry;
	
	private double revenue;
	
	
	@OneToMany(mappedBy="company")
	private List<Product> products = new ArrayList<>();


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


	public String getIndustry() {
		return industry;
	}


	public void setIndustry(String industry) {
		this.industry = industry;
	}


	public double getRevenue() {
		return revenue;
	}


	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Company(long id, String name, String industry, double revenue, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.industry = industry;
		this.revenue = revenue;
		this.products = products;
	}


	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", industry=" + industry + ", revenue=" + revenue
				+ ", products=" + products + "]";
	}

	
	
	
	
	
}
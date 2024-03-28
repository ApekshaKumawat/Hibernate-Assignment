package HibernateAssignment.OneToManyMapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String type;
	@NotEmpty
	private String name;
	@NotNull
	private double price;
	
	@ManyToOne
	private Company company;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Product(long id, String type, String name, double price, Company company) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.price = price;
		this.company = company;
	}

	

	public Product() {
		// TODO Auto-generated constructor stub
		super();
	}

//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", type=" + type + ", name=" + name + ", price=" + price + ", companies="
//				+ company + "]";
//	}

	
	
}

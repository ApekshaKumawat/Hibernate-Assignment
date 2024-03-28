package HibernateAssignment.OneToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import HibernateAssignment.OneToManyMapping.configuration.HibernateUtils;
import HibernateAssignment.OneToManyMapping.entity.Company;
import HibernateAssignment.OneToManyMapping.entity.Product;

public class App 
{
    public static void main( String[] args )
    {
    	try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
                Session session = sessionFactory.openSession()) {
               session.beginTransaction();

    			Company company = new Company();
    			company.setName("xyz");
    			company.setIndustry("Chemical Industry");
    			company.setRevenue(50000);
    			
    			Product product1 = new Product();
    			product1.setName("Cleaner");
    			product1.setType("Cleansing");
    			product1.setPrice(2500);
    			product1.setCompany(company);
    			
    			Product product2 = new Product();
    			product2.setName("Perfume");
    			product2.setType("Fragrances");
    			product2.setPrice(2500);
    			product2.setCompany(company);
    			
    			List<Product> products = new ArrayList<>();
    			products.add(product1);
    			products.add(product2);
    			
    			
    			company.setProducts(products);
    			
    			session.persist(company);
    			session.persist(product1);
    			session.persist(product2);
    			session.getTransaction().commit();
    			
    			Query<Product> query = session.createQuery("from Product", Product.class);
    	        List<Product> product = query.getResultList();
    	        for (Product f : product) {
    	             System.out.println("Name: " + f.getId() + ", Email: " + f.getName() + ", PhoneNo: " + f.getPrice() + ", CompanyName: " + f.getCompany().getName());
    	         }
    			
    			
         }catch(Exception e) {
    		System.out.println(e);
    	}
    	
    
}
}

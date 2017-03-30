package ua.com.magaz;




import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@NamedQuery(name="findByNameCommodity",query = "select c from Commodity c where c.name like:name")
@Entity
public class Commodity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String name;
	private String color;
	private double price;
	//private LocalDate dateOfProducing;
	private int ageOfProduction;
	private String commodityImage;
	@ManyToOne
	private CategoryOfCommodity categoryOfCommodity;
	@ManyToOne
	private Producer producer;
	/*@ManyToMany
	@JoinTable(name="commodity_order",joinColumns=@JoinColumn(name="commodity_id"),inverseJoinColumns=@JoinColumn(name="order_id"))
	private List<Orders> orders;*/
	@ManyToOne
	Customer customer;
	
	

	public String getCommodityImage() {
		return commodityImage;
	}



	public void setCommodityImage(String commodityImage) {
		this.commodityImage = commodityImage;
	}

	
	


	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Commodity() {
		super();
	}
	
	

public Commodity(String name, String color, double price, int ageOfProduction) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
		this.ageOfProduction = ageOfProduction;
	}



//	public LocalDate getDateOfProducing() {
//		return dateOfProducing;
//	}
//
//	public void setDateOfProducing(LocalDate dateOfProducing) {
//		this.dateOfProducing = dateOfProducing;
//	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
//	public ÑategoryOfCommodity getCategoryOfCommodity() {
//		return categoryOfCommodity;
//	}
//	public void setCategoryOfCommodity(ÑategoryOfCommodity categoryOfCommodity) {
//		this.categoryOfCommodity = categoryOfCommodity;
//	}
	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	

	
	public CategoryOfCommodity getCategoryOfCommodity() {
		return categoryOfCommodity;
	}

	public void setCategoryOfCommodity(CategoryOfCommodity categoryOfCommodity) {
		this.categoryOfCommodity = categoryOfCommodity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAgeOfProduction() {
		return ageOfProduction;
	}

	public void setAgeOfProduction(int ageOfProduction) {
		this.ageOfProduction = ageOfProduction;
	}

	
	
	
	
	
	
	
}

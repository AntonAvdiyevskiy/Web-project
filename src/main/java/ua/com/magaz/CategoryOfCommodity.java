package ua.com.magaz;

import java.util.List;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@NamedQuery(name="findByNameCategory",query="select c from CategoryOfCommodity c where c.name like:name")
@Entity
public class CategoryOfCommodity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private String status;
	@OneToMany(mappedBy = "categoryOfCommodity",fetch = FetchType.LAZY)
	private List<Commodity>commodities;
	
	public CategoryOfCommodity() {
		super();
	}
	
	

	public CategoryOfCommodity(String name, String type, String status) {
		super();
		this.name = name;
		this.type = type;
		this.status = status;
	}



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
	
	
	public List<Commodity> getCommodities() {
		return commodities;
	}
	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
}

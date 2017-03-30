package ua.com.magaz;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
public class Producer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String countryName;
	
	@OneToMany(mappedBy = "producer",fetch = FetchType.LAZY)
	private List<Commodity>commodities;
	public Producer() {
		super();
	}
	public Producer( String name, String countryName) {
		super();
		
		this.name = name;
		this.countryName = countryName;
		
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
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public List<Commodity> getCommodities() {
		return commodities;
	}
	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}
	@Override
	public String toString() {
		return "producer - "+name;
	}
	
	
	
	
	
	
	
}

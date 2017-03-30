package ua.com.dto;

public class CategoryOfCommodityDto {

	private String name;
	private String type;
	private String status;
	public CategoryOfCommodityDto(String name, String type, String status) {
		super();
		this.name = name;
		this.type = type;
		this.status = status;
	}
	public CategoryOfCommodityDto() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

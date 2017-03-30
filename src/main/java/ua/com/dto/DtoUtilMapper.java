package ua.com.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.magaz.CategoryOfCommodity;
import ua.com.magaz.Commodity;
import ua.com.magaz.Customer;

import ua.com.magaz.Producer;

public class DtoUtilMapper {

	public static List<CustomerDto> customerToCustomerDto(List<Customer> customers){
		List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
		for (Customer customer : customers) {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setLogin(customer.getLogin());
			customerDto.setMail(customer.getMail());
			customerDto.setId(customer.getId());
			customerDtos.add(customerDto);
		}
		return customerDtos;
	}
	


	public static List<CategoryOfCommodityDto> CategoryToCategoryDto(List<CategoryOfCommodity>categoryOfCommodities){
		List<CategoryOfCommodityDto>categoryOfCommodityDtos = new ArrayList<CategoryOfCommodityDto>();
		for(CategoryOfCommodity category:categoryOfCommodities){
			CategoryOfCommodityDto categoryOfCommodityDto = new CategoryOfCommodityDto();
			categoryOfCommodityDto.setName(category.getName());
			categoryOfCommodityDto.setStatus(category.getStatus());
			categoryOfCommodityDto.setType(category.getType());
			categoryOfCommodityDtos.add(categoryOfCommodityDto);
			
		}
		return categoryOfCommodityDtos;
	}
	public static List<ProducerDto>ProducerToProducerDto(List<Producer>producers){
		List<ProducerDto>producerDtos = new ArrayList<ProducerDto>();
		for(Producer producer:producers){
			ProducerDto producerDto = new ProducerDto();
			producerDto.setName(producer.getName());
			producerDto.setCountryName(producer.getCountryName());
			producerDtos.add(producerDto);
		}
		return producerDtos;
	}
	public static List<CommodityDto> CommodityToCommodity(List<Commodity>commodities){
		List<CommodityDto>commodityDtos = new ArrayList<CommodityDto>();
		for(Commodity commodity:commodities){
			CommodityDto commodityDto = new CommodityDto();
			commodityDto.setName(commodity.getName());
			commodityDto.setPrice(commodity.getPrice());
			commodityDto.setAgeOfProduction(commodity.getAgeOfProduction());
			commodityDto.setColor(commodity.getColor());
			commodityDtos.add(commodityDto);
		}
		return commodityDtos;
	}
}
package ua.com.service;

import java.util.List;

import ua.com.magaz.CategoryOfCommodity;

public interface CategoryOfCommodityService {

	void save(CategoryOfCommodity categoryOfCommodity) throws Exception;
	List<CategoryOfCommodity> findAll();
	CategoryOfCommodity findOneByName(int id);
	void delete(int id);
	
	void deleteCommodityFromCategory(String idCommodity);
	List<CategoryOfCommodity> findCategoryWithCommodities();
	void saveAndFlush(CategoryOfCommodity categoryOfCommodity);
} 

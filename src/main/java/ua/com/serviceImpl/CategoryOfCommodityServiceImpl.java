package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.dao.CategoryOfCommodityDao;
import ua.com.dao.CommodityDao;
import ua.com.magaz.CategoryOfCommodity;
import ua.com.magaz.Commodity;
import ua.com.service.CategoryOfCommodityService;
import ua.com.validation.Validator;

@Service("categoryOfCommodityService")
public class CategoryOfCommodityServiceImpl implements CategoryOfCommodityService{

	@Autowired
	private CategoryOfCommodityDao categoryOfCommodityDao;
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	@Qualifier("categoryValidator")
	private Validator validator;
	public void save(CategoryOfCommodity categoryOfCommodity) throws Exception {
		// TODO Auto-generated method stub
		validator.validate(categoryOfCommodity);
		categoryOfCommodityDao.save(categoryOfCommodity);
	}

	public List<CategoryOfCommodity> findAll() {
		// TODO Auto-generated method stub
		return categoryOfCommodityDao.findAll();
	}

	public CategoryOfCommodity findOneByName(int id) {
		// TODO Auto-generated method stub
		return categoryOfCommodityDao.findOne(id);
	}
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
	//	categoryOfCommodityDao.delete(id);
		CategoryOfCommodity categoryOfCommodity = categoryOfCommodityDao.findCategoryWithCommodity(id);
		for(Commodity commodity: categoryOfCommodity.getCommodities()){
			commodity.setCategoryOfCommodity(null);
			commodityDao.save(commodity);
			
		}
		categoryOfCommodityDao.delete(categoryOfCommodity);
	}
	
	@Transactional
	public void deleteCommodityFromCategory(String idCommodity) {
		// TODO Auto-generated method stub
		Commodity commodity = commodityDao.findOne(Integer.parseInt(idCommodity));
		commodity.setCategoryOfCommodity(null);
		commodityDao.save(commodity);
	}

	public List<CategoryOfCommodity> findCategoryWithCommodities() {
		// TODO Auto-generated method stub
		return categoryOfCommodityDao.findCategoryWithCommodity();
	}
	public void saveAndFlush(CategoryOfCommodity categoryOfCommodity){
		categoryOfCommodityDao.saveAndFlush(categoryOfCommodity);
	}

	
}

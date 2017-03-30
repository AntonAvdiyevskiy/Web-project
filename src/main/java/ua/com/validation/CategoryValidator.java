package ua.com.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.dao.CategoryOfCommodityDao;

import ua.com.magaz.CategoryOfCommodity;

@Component("categoryValidator")
public class CategoryValidator implements Validator {
	@Autowired
	CategoryOfCommodityDao categoryOfCommodityDao;

	public void validate(Object object) throws Exception {
		// TODO Auto-generated method stub
		CategoryOfCommodity categoryOfCommodity = (CategoryOfCommodity)object;
		if(categoryOfCommodity.getName().isEmpty()){
			throw new CategoryValidationExeption(ValidationMassages.EMPTY_CATEGORY_NAME_FIELD);
			
		}
		if(categoryOfCommodity.getStatus().isEmpty()){
			throw new CategoryValidationExeption(ValidationMassages.EMPTY_CATEGORY_STATUS_FIELD);
		}
		if(categoryOfCommodity.getType().isEmpty()){
			throw new CategoryValidationExeption(ValidationMassages.EMPTY_CATEGORY_TYPE_FIELD);
		}
		if(categoryOfCommodityDao.findByName(categoryOfCommodity.getName())!=null){
			throw new  CategoryValidationExeption(ValidationMassages.CATEGORY_NAME_ALREADY_EXIST);
		}
	}

}

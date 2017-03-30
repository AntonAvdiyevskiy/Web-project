package ua.com.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.dao.CommodityDao;
import ua.com.magaz.Commodity;

@Component("commodityValidator")
public class CommodityValidator implements Validator{

	@Autowired
	private CommodityDao commodityDao;
	public void validate(Object object) throws Exception {
		Commodity commodity = (Commodity) object;
		// TODO Auto-generated method stub
		if(commodityDao.findOneByName(commodity.getName())!= null){
			throw new CommodityValidationException(ValidationMassages.COMMODITY_ALREADY_EXIST);
		}
	}

	

}

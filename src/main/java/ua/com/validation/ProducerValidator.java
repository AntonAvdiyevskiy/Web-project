package ua.com.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.dao.ProducerDao;
import ua.com.magaz.Producer;

@Component("producerValidator")
public class ProducerValidator implements Validator {

	@Autowired
	ProducerDao  producerDao;
	public void validate(Object object) throws Exception {
		// TODO Auto-generated method stub
		Producer producer = (Producer)object;
		if(producer.getName().isEmpty()){
			throw new ProducerValidationExeption(ValidationMassages.EMPTY_Producer_FIELD);
		}else if(producer.getCountryName().isEmpty()){
			throw new ProducerValidationExeption(ValidationMassages.EMPTY_COUNTRY_FIELD);
		}else if(producerDao.findOneByName(producer.getName())!=null){
			throw new ProducerValidationExeption(ValidationMassages.Producer_ALREADY_EXIST);
		}
	}

}

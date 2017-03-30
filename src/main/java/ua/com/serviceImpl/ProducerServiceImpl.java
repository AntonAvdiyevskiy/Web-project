package ua.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.com.dao.ProducerDao;

import ua.com.magaz.Producer;
import ua.com.service.ProducerService;
import ua.com.validation.Validator;
@Service("producerService")
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private ProducerDao producerDao;
	@Autowired
	@Qualifier("producerValidator")
	private Validator validator;
	public void save(Producer producer) throws Exception {
		// TODO Auto-generated method stub
		validator.validate(producer);
		producerDao.save(producer);
	}

	public List<Producer> getAll() {
		// TODO Auto-generated method stub
		return producerDao.findAll();
	}

	public Producer getOne(int id) {
		// TODO Auto-generated method stub
		return producerDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		producerDao.delete(id);
	}

	

	

	
	

}

package ua.com.service;

import java.util.List;


import ua.com.magaz.Producer;

public interface ProducerService {
	void save(Producer producer) throws Exception;
	List<Producer>getAll();
	Producer getOne(int id);
	void delete(int id);
	
	
}

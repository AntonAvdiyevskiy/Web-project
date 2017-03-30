package ua.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.magaz.Producer;

public interface ProducerDao extends JpaRepository<Producer, Integer> {

//	void save(Producer producer);
//	List<Producer> findAll();
	Producer findOneByName(String name);
//	void delete(String name);
//	public Producer findProducerWithAcousticGuitar (String name);
}

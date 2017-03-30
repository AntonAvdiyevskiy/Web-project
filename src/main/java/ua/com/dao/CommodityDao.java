package ua.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.magaz.Commodity;

public interface CommodityDao extends JpaRepository<Commodity, Integer> {

//	void save(Commodity commodity);
//	List<Commodity> findAll();
	Commodity findOneByName(String name);
//	void delete(String name);
//	@Query("select  c from Commodity c where c.name :=name")
//	Commodity toFindCommodityByName(@Param("name")String name);
	 @Query("select b from Commodity b where b.name LIKE CONCAT('%',:search,'%')")
	    List<Commodity> liveSearch(@Param("search") String search);
	 /*@Query("delete b from Commodity b where b.customer_id ==:id")
	 	void deleteCommodity(@Param("id") int id);*/
	 @Query("select c from Commodity c where c.price > :price")
	 List<Commodity> sortCommodities(@Param("price") int price);

}	

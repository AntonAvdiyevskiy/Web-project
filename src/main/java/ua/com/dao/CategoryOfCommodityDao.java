package ua.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.magaz.CategoryOfCommodity;


public interface CategoryOfCommodityDao extends JpaRepository<CategoryOfCommodity, Integer> {

//	void save(CategoryOfCommodity categoryOfCommodity);
//	List<CategoryOfCommodity> findAll();
//	CategoryOfCommodity findOneByName(String name);
//	void delete(String name);
	CategoryOfCommodity findByName(String name);
	@Query("select distinct a from CategoryOfCommodity a left join fetch a.commodities")
	List<CategoryOfCommodity>findCategoryWithCommodity();
	@Query("select distinct a from CategoryOfCommodity a left join fetch a.commodities where a.id =:id")
	CategoryOfCommodity findCategoryWithCommodity(@Param("id") int id);
}

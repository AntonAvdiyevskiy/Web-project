package ua.com.service;

import java.security.Principal;
import java.util.List;



import org.springframework.web.multipart.MultipartFile;

import ua.com.magaz.Commodity;


public interface CommodityService {

	/*void save(Commodity commodity,MultipartFile image);*/
	void save(Commodity commodity) throws Exception ;
	List<Commodity>getAll();
	Commodity getOne(int id);
	void delete(int id);
	List<Commodity> liveSearch(String search);
	List<Commodity> sortCommodities(int price);
	public void saveImage(int id, MultipartFile multipartFile);
	
//	public Commodity toFindCommodityByName(String name);
}

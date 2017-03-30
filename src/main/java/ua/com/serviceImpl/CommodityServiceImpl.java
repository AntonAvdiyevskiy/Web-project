package ua.com.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.dao.CommodityDao;
import ua.com.magaz.Commodity;
import ua.com.magaz.Customer;
import ua.com.service.CommodityService;
import ua.com.validation.Validator;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	@Qualifier("commodityValidator")
	private Validator validator;
	@Transactional
	/*public void save(Commodity commodity,MultipartFile image) {
		// TODO Auto-generated method stub
		
		commodityDao.saveAndFlush(commodity);
		String path = System.getProperty("catalina.home") + "/resources/" + commodity.getName() + "/"
				+ image.getOriginalFilename();

		commodity.setCommodityImage("resources/" + commodity.getName() + "/" + image.getOriginalFilename());

		File file = new File(path);

		try {
			file.mkdirs();
			try {
				FileUtils.cleanDirectory(
						new File(System.getProperty("catalina.home") + "/resources/" + commodity.getName() + "/"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			image.transferTo(file);
		} catch (IOException e) {
			System.out.println("error with file");
		}
	}*/

	public List<Commodity> getAll() {
		// TODO Auto-generated method stub
		return commodityDao.findAll();
	}

	public Commodity getOne(int id) {
		// TODO Auto-generated method stub
		return commodityDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		commodityDao.delete(id);
	}

	public List<Commodity> liveSearch(String search) {
		// TODO Auto-generated method stub
		return commodityDao.liveSearch(search);
	}

	public List<Commodity> sortCommodities(int price) {
		// TODO Auto-generated method stub
		return commodityDao.sortCommodities(price);
	}

	public void save(Commodity commodity) throws Exception {
		// TODO Auto-generated method stub
		validator.validate(commodity);
		commodityDao.save(commodity);
	}

	public void saveImage(int id, MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		Commodity commodity = commodityDao.findOne(id);

	    String path = System.getProperty("catalina.home") + "/resources/"
	            + commodity.getName() + "/" + multipartFile.getOriginalFilename();

	    commodity.setCommodityImage("resources/" + commodity.getName() + "/" + multipartFile.getOriginalFilename());

	    File file = new File(path);

	    try {
	        file.mkdirs();
	        /*try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home") + "/resources/" + customer.getLogin() + "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }*/
	        try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home") + "/resources/" + commodity.getName() + "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        multipartFile.transferTo(file);
	    } catch (IOException e) {
	        System.out.println("error with file");
	    }
	    commodityDao.save(commodity);
	}

	/*public void save(Commodity commodity) {
		// TODO Auto-generated method stub
		
	}*/

	

	

	/*public Commodity toFindCommodityByName(String name) {
		// TODO Auto-generated method stub
		return commodityDao.toFindCommodityByName(name);
	}*/

	
}

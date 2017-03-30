package ua.com.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import ua.com.magaz.Commodity;
import ua.com.magaz.Customer;

public interface CustomerService {

	void save(Customer customer) throws Exception;
	List<Customer> findAll();
	Customer findOneByName(int id);
	void delete(int id);
	Customer findByLogin(String login);
	/////////////////////////////////////////////////////////////////////////////////
	/*public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response);
    List<Commodity> customerCommodityCookie(HttpServletRequest request);
    public void getOrder(Principal principal, String id, HttpServletRequest request, HttpServletResponse response);
    public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response);*/
    ////////////////////////////////////////////////////////////////////////////////
	/*public void toBuy(Principal principal,String id);*/
	
	public void deleteCommodityFromCustomer(Principal principal,int id);
	public void saveImage(Principal principal, MultipartFile multipartFile);
	public Customer findByUuid(String uuid);
	void update(Customer customer) throws Exception;
	void buyCommodity(Principal principal, String id);
	/*void deleteCommodity(Principal principal,String id);*/
	Customer fetchCustomerWithCommodities(int id);
	  void updateProfile(Customer customer);
	
}

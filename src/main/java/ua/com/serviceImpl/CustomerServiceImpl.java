package ua.com.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.com.dao.CommodityDao;
import ua.com.dao.CustomerDao;

import ua.com.magaz.Commodity;
import ua.com.magaz.Customer;

import ua.com.magaz.Role;
import ua.com.service.CustomerService;
import ua.com.validation.Validator;

@Service("userDetailsService")
public class CustomerServiceImpl implements CustomerService,UserDetailsService {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	CommodityDao commodityDao;
	
	
	@Autowired
	@Qualifier("customerValidator")
	private Validator validator;

	
	public void save(Customer customer) throws Exception {
		//validator.validate(customer);
		// TODO Auto-generated method stub
		validator.validate(customer);
		customer.setRole(Role.ROLE_USER);
		customer.setPassword(encoder.encode(customer.getPassword()));
		customerDao.save(customer);
	}

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	public Customer findOneByName(int id) {
		// TODO Auto-generated method stub
		return customerDao.findOne(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		customerDao.delete(id);
	}

	public Customer findByLogin(String login) {
		// TODO Auto-generated method stub
		return customerDao.findByLogin(login);
	}

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return customerDao.findByLogin(login);
	}
	/*@Transactional
	public void toBuy(Principal principal, String id) {
		// TODO Auto-generated method stub
		Orders orders = ordersDao.findOne(Integer.parseInt(id));
		Customer customer = customerDao.findOne(Integer.parseInt(principal.getName()));
		
		customer.getOrders().add(orders);
		
	}*/

	@Transactional
	public void deleteCommodityFromCustomer(Principal principal, int id) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.findOne(Integer.parseInt(principal.getName()));
		customer.getCommodities().remove(commodityDao.findOne(id));
	}

	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {

	    Customer customer = customerDao.findOne(Integer.parseInt(principal.getName()));

	    String path = System.getProperty("catalina.home") + "/resources/"
	            + customer.getLogin() + "/" + multipartFile.getOriginalFilename();

	    customer.setPathImage("resources/" + customer.getLogin() + "/" + multipartFile.getOriginalFilename());

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
	                    (new File(System.getProperty("catalina.home") + "/resources/" + customer.getLogin() + "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        multipartFile.transferTo(file);
	    } catch (IOException e) {
	        System.out.println("error with file");
	    }
	    customerDao.save(customer);
	}

	public Customer findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return customerDao.findByUuid(uuid);
	}

	public void update(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		validator.validate(customer);
		customerDao.save(customer);
	}

	public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.getSession(false);
        Commodity commodity = commodityDao.findOne(id);

        Cookie cookieCommodity =
                new Cookie(commodity.getName(), String.valueOf(commodity.getId()));
        cookieCommodity.setMaxAge(24 * 60 * 60 * 60);
        cookieCommodity.setHttpOnly(true);
        cookieCommodity.setPath("/");

        response.addCookie(cookieCommodity);
        return cookieCommodity;
	}

	public List<Commodity> customerCommodityCookie(HttpServletRequest request) {
		// TODO Auto-generated method stub
		 request.getSession(false);
	        List<Commodity> commodities = new ArrayList<Commodity>();
	        for (Cookie cookie : request.getCookies()) {
	            if (cookie.getName().equals("JSESSIONID")) {

	            } else {
	                commodities.add(commodityDao.findOne(Integer.parseInt(cookie.getValue())));
	            }
	        }
	        return commodities;
	}
	/*@Transactional
    public void getOrder(Principal principal, String id, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.fetchCustomerWithOrders(Integer.parseInt(principal.getName()));
        Commodity commodity = commodityDao.findOne(Integer.parseInt(id));
        customer.getCommodities().add(commodity);
        

        Cookie[] cookies = request.getCookies();
        sortCookie(cookies, id, response);
	}
*/
	public void deleteCookieFromOrder(String id, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 Cookie[] cookies = request.getCookies();
	        sortCookie(cookies, id, response);
	}
	public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
        for (int i = 0; i < cookies.length; i++) {
            if (id.equals(cookies[i].getValue())) {
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setHttpOnly(true);
                cookie.setPath("/");
                cookie.setValue(null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
       
        
    }
	@Transactional
	public void buyCommodity(Principal principal, String id) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.findOne(Integer.parseInt(principal.getName()));
		Commodity commodity = commodityDao.findOne(Integer.parseInt(id));
		commodity.setCustomer(customer);
	}

	public Customer fetchCustomerWithCommodities(int id) {
		// TODO Auto-generated method stub
		return customerDao.fetchCustomerWithCommodities(id);
	}

	public void updateProfile(Customer customer) {
		// TODO Auto-generated method stub
		customer.setPassword(encoder.encode(customer.getPassword()));
		customerDao.save(customer);
	}

	/*public void deleteCommodity(Principal principal, String id) {
		// TODO Auto-generated method stub
		
		commodityDao.deleteCommodity(Integer.parseInt(id));
	}*/

	

	

}

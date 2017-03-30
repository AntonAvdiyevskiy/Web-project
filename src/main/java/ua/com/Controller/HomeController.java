package ua.com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.dto.CommodityDto;
import ua.com.dto.DtoUtilMapper;
import ua.com.magaz.Commodity;
import ua.com.service.CommodityService;
import ua.com.service.CustomerService;

@Controller
public class HomeController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CommodityService commodityService;

	@RequestMapping(value = {"/","/home"}, method=RequestMethod.GET)
	public String home(Model model){
		model.addAttribute("customers", customerService.findAll());
		model.addAttribute("commodities",commodityService.getAll());
		return "views-base-home";
	}
	@RequestMapping(value="/home",method= RequestMethod.POST)
	public String loginprocesing(){
		return "redirect:/home";
	}
	@RequestMapping(value="/loginpage")
	public String login(){
		return "views-base-loginpage";
	}
	@RequestMapping(value="/logout",method= RequestMethod.POST)
	public String logout(){
		return "redirect:/";
	}
//	@RequestMapping(value="/registration",method= RequestMethod.POST)
//	public String registration(){
//		return "views-User-registration";
//	}

	@RequestMapping(value = "/liveSearchBooks", method = RequestMethod.POST)
	public @ResponseBody List<CommodityDto> liveSearchCommodities(@RequestBody String search){

		System.out.println(search);

		System.out.println(commodityService.liveSearch(search));
		for (Commodity commodity : commodityService.liveSearch(search)) {
			System.out.println(commodity);
		}

		List<Commodity> commodityList = commodityService.liveSearch(search);

		return DtoUtilMapper.CommodityToCommodity(commodityList);
	}
}

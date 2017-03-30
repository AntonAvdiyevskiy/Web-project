package ua.com.Controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import ua.com.dto.CommodityDto;
import ua.com.dto.CustomerDto;
import ua.com.dto.DtoUtilMapper;
import ua.com.editor.CategoryOfCommodityEditor;
import ua.com.editor.ProducerEditor;
import ua.com.magaz.CategoryOfCommodity;
import ua.com.magaz.Commodity;

import ua.com.magaz.Producer;
import ua.com.service.CategoryOfCommodityService;
import ua.com.service.CommodityService;

import ua.com.service.ProducerService;
import ua.com.validation.ValidationMassages;

@Controller
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CategoryOfCommodityService categoryOfCommodityService;
	@Autowired
	private ProducerService producerService;
	
	@InitBinder
	public  void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(CategoryOfCommodity.class, new CategoryOfCommodityEditor(categoryOfCommodityService));
		binder.registerCustomEditor(Producer.class,new ProducerEditor(producerService) );
		// TODO Auto-generated method stub

	}
	
	@RequestMapping(value = "/newCommodity",method = RequestMethod.GET)
	public String newCommodity(Model model){
		List<Commodity>commoditiesFromDB = commodityService.getAll();
		model.addAttribute("commodities",commoditiesFromDB);
	//	model.addAttribute("categoryOfCommodities", categoryOfCommodityService.findAll());
		model.addAttribute("commodity",new Commodity() );
		model.addAttribute("categoriesOfCommodity",categoryOfCommodityService.findAll());
		model.addAttribute("producers",producerService.getAll());
		
		return "views-admin-newCommodity";
		}
	
	@RequestMapping(value = "/saveCommodity",method = RequestMethod.POST)
	public String saveCommodity(@ModelAttribute Commodity commodity,
								/*@RequestParam String name,
								@RequestParam String color,*/
								@RequestParam String price,
								@RequestParam String ageOfProduction,
								Model model
								/*@RequestParam MultipartFile  image*/
								/*@PathVariable int id, 
								@RequestParam MultipartFile image
								*/
								/*@RequestParam String date*/
								 /*@RequestParam MultipartFile image*/
								){
		commodity.setPrice(Integer.parseInt(price));
		commodity.setAgeOfProduction(Integer.parseInt(ageOfProduction));
		/*commodityService.saveImage(id, image);*/
		//commodityService.save(commodity);
		
		
		
		
		
		
		
		
		try {
			commodityService.save(commodity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(e.getMessage().equals(ValidationMassages.COMMODITY_ALREADY_EXIST)){
				model.addAttribute("commodityException", e.getMessage());
			}
		}
		return "redirect:/newCommodity";
		}
	@RequestMapping(value = "/deleteCommodity/{id}",method = RequestMethod.GET)
	public String newCommodity(@PathVariable int id){
		commodityService.delete(id);
		return "redirect:/newCommodity";
			}
	/*@RequestMapping(value = "/loadCommodity", method = RequestMethod.POST)
    public @ResponseBody List<CommodityDto> save—ommodity() {


       return DtoUtilMapper.CommodityToCommodity(commodityService.getAll());

    	}*/
	/*@PostMapping("saveManyImages")
	public String saveManyImages(@RequestParam MultipartFilter []images){
		return "";
	}*/
	@RequestMapping(value = "/saveCommodityImage", method = RequestMethod.POST)
	public String saveCommodityImage(@PathVariable int id, @RequestParam MultipartFile image) {
		
		commodityService.saveImage(id, image);

		return "redirect:/newCommodity";
	}
	
	}
	



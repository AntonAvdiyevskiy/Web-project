package ua.com.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import ua.com.magaz.CategoryOfCommodity;
import ua.com.service.CategoryOfCommodityService;
import ua.com.validation.ValidationMassages;


@Controller
public class CategoryOfCommodityController {

	@Autowired
	private CategoryOfCommodityService categoryOfCommodityService;
	
	@RequestMapping(value = "/newCategoryOfCommodity",method = RequestMethod.GET)
	public String newCategoryOfCommodity(Model model){
		
		model.addAttribute("categoriesOfCommodity",categoryOfCommodityService.findCategoryWithCommodities());
		model.addAttribute("categoryOfCommodity",new CategoryOfCommodity() );
		return "views-admin-newCategoryOfCommodity";
		}
	
	@RequestMapping(value = "/saveCategoryOfCommodity",method = RequestMethod.POST)
	public String saveCategoryOfCommodity(/*@RequestParam String name,@RequestParam String availability*/
			@ModelAttribute CategoryOfCommodity categoryOfCommodity,Model model) {
	try{
		categoryOfCommodityService.save(categoryOfCommodity);
	}catch(Exception e){
		if(e.getMessage().equals(ValidationMassages.EMPTY_CATEGORY_NAME_FIELD)||
				e.getMessage().equals(ValidationMassages.CATEGORY_NAME_ALREADY_EXIST)){
			model.addAttribute("nameException", e.getMessage());
		}else if(e.getMessage().equals(ValidationMassages.EMPTY_CATEGORY_STATUS_FIELD )){
			model.addAttribute("statusException", e.getMessage());
		}else if(e.getMessage().equals(ValidationMassages.EMPTY_CATEGORY_TYPE_FIELD)){
			model.addAttribute("typeException", e.getMessage());
		}
		return "redirect:/newCategoryOfCommodity";
	}
		return "redirect:/";
		}
	@RequestMapping(value = "/deleteCategoryOfCommodity/{id}",method = RequestMethod.GET)
	public String newCategoryOfCommodity(@PathVariable String id){
		categoryOfCommodityService.delete(Integer.parseInt(id));
		return "redirect:/newCategoryOfCommodity";
	}
	@RequestMapping(value="/deleteCommodityFromCategory/{idCommodity}")
	public String deleteCommodityFromCategory (@PathVariable String idCommodity){
		categoryOfCommodityService.deleteCommodityFromCategory(idCommodity);
		return "redirect:/newCategoryOfCommodity";
		
	}

}

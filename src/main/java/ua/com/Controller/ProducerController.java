package ua.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import ua.com.magaz.Producer;

import ua.com.service.ProducerService;
import ua.com.validation.ProducerValidationExeption;
import ua.com.validation.ValidationMassages;


@Controller
public class ProducerController {


	@Autowired
	private ProducerService producerService;
	

	
	@RequestMapping(value = "/newProducer",method = RequestMethod.GET)
	public String newProducer(Model model){
		model.addAttribute("producers",producerService.getAll());
		model.addAttribute("producer", new Producer());
		
		
		
		return "views-admin-newProducer";
		}
	
	@RequestMapping(value = "/saveProducer",method = RequestMethod.POST)
	public String saveProducer(/*@RequestParam String name,@RequestParam String countryName,@RequestParam String acousticGuitarId*/
			
			@ModelAttribute Producer producer,Model model){
//		Producer producer = new Producer(name, countryName);
//		System.out.println(acousticGuitarId);
//		int idacou = Integer.parseInt(acousticGuitarId);
		try {
			producerService.save(producer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(e.getMessage().equals(ValidationMassages.Producer_ALREADY_EXIST)|| e.getMessage().
					equals(ValidationMassages.EMPTY_Producer_FIELD)){
				model.addAttribute("producerException", e.getMessage());
			}else if(e.getMessage().equals(ValidationMassages.EMPTY_COUNTRY_FIELD)){
				model.addAttribute("countryException", e.getMessage());
			}
		}
		
		return "redirect:/newProducer";
		}
	@RequestMapping(value = "/deleteProducer/{id}",method = RequestMethod.GET)
	public String deleteProducer(@PathVariable int id){
		producerService.delete(id);
		return "redirect:/newProducer";
	}
	

}

package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.service.CategoryOfCommodityService;
import ua.com.service.ProducerService;

public class ProducerEditor extends PropertyEditorSupport {
	private final ProducerService producerService;

	public ProducerEditor(ProducerService producerService) {
		
		this.producerService = producerService;
	}
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(producerService.getOne(Integer.parseInt(text)));
	}
	
	

}

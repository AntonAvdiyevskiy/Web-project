package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.service.CategoryOfCommodityService;

public class CategoryOfCommodityEditor extends PropertyEditorSupport {
	private final CategoryOfCommodityService categoryOfCommodityService;

	public CategoryOfCommodityEditor(CategoryOfCommodityService categoryOfCommodityService) {
		super();
		this.categoryOfCommodityService = categoryOfCommodityService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(categoryOfCommodityService.findOneByName(Integer.parseInt(text)));
	}

}

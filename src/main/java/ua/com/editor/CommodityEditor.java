package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.service.CommodityService;

public class CommodityEditor extends PropertyEditorSupport {
	private final CommodityService commodityService;

	public CommodityEditor(CommodityService commodityService) {
		
		this.commodityService = commodityService;
	}
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(commodityService.getOne(Integer.parseInt(text)));
	}

}

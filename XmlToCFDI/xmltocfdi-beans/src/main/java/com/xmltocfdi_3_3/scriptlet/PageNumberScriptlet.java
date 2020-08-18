package com.xmltocfdi_3_3.scriptlet;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class PageNumberScriptlet extends JRDefaultScriptlet {
	private Integer page_number;
	private Integer page_count;

	public void afterPageInit() throws JRScriptletException {
		this.page_number = (Integer) this.variablesMap.get("PAGE_NUMBER").getValue();
		this.page_number++;
		
		this.page_count = (Integer) this.variablesMap.get("PAGE_COUNT").getValue();
		this.page_count++;
		
	}

	public String getPageNum() throws JRScriptletException {
		return String.valueOf(page_number);
	}

	public String getPageCount() throws JRScriptletException {
		return String.valueOf(page_count);
	}
	
	public PageNumberScriptlet getScriptlet() throws JRScriptletException {
		return this;
	}
}

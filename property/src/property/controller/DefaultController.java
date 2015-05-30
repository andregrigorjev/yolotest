package property.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;






import property.model.*;
import property.service.*;


@Controller
@RequestMapping(value="/")
public class DefaultController {

	@Autowired
	private PropertyService propertyService ;


	@RequestMapping(method=RequestMethod.GET)
	public String getProperty(Model model) {
		List<Property> properties = null;
		properties = propertyService.getProperties();
		model.addAttribute("properties",properties);
		return "mainForm";
	}


}

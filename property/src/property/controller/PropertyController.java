package property.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import property.log.MyLogger;
import property.model.Property;
import property.service.PropertyService;

@Controller
@RequestMapping(value="/s")
public class PropertyController {

	@Autowired
	private PropertyService propertyService ;

	Property selectedProperty;
	Property updatableProperty;



	/*@RequestMapping(value = "/{property_Id}", method=RequestMethod.GET)
	public String getProperty(@PathVariable Integer property_Id, Model model) {
		selectedProperty = propertyService.getPropertyById(property_Id);
		model.addAttribute("property",selectedProperty);
		return "propertyForm";
	}*/


	/*@RequestMapping(value = "/{property_Id}",method = RequestMethod.POST)
	public String updateProperty(@ModelAttribute("property") @Valid final Property updatableProperty, final BindingResult result, Model model) {

		if (result.hasErrors()) { 
			MyLogger.Log("OLID VEAD:","");
			model.addAttribute("saveinfo", "Ei salvestatud vigade pärast");
			return "propertyForm";
		}
		else
		{
			MyLogger.Log("SALVESTASIN:","");
		}
		propertyService.update(updatableProperty);
		model.addAttribute("saveinfo", "Salvestati edukalt");
		return "propertyForm";
	}*/
	
	@RequestMapping(method=RequestMethod.GET)
	public String getProperty(Model model) {
		List<Property> properties = null;
		properties = propertyService.getProperties();
		model.addAttribute("properties",properties);
		return "mainForm";
	}
	
	@RequestMapping(method = RequestMethod.GET, params="id")
	public String getProperty(@RequestParam("id") String property_Id, Model model) {
		int propertyID = 0;
		try{
			propertyID = Integer.parseInt(property_Id);
		} catch(Exception ex) {
			propertyID = -1;
		}
		
		try	{	
			
			selectedProperty = propertyService.getPropertyById(propertyID);
			model.addAttribute("property",selectedProperty);
			return "propertyForm";
		} catch(Exception ex)	{
			System.out.println("PropertyController.getProperties():"+ex.getMessage());
			MyLogger.Log("SropertyController.getProperties():",ex.getMessage());
			model.addAttribute("generalError","Unknown error.Try again");
			return "propertyForm";
		}

	}
	
	
	@RequestMapping(method = RequestMethod.POST, params={"id"})
	public String updateProperty(@RequestParam("id") Integer property_Id,  @ModelAttribute("property") @Valid final Property updatableProperty, final BindingResult result, Model model) {
		String whatView="mainForm";

		try	{
			if (result.hasErrors()) { 
				MyLogger.Log("OLID VEAD:","");
				model.addAttribute("saveinfo", "Ei salvestatud vigade pärast");
				return "propertyForm";
			} else 			{
				MyLogger.Log("SALVESTASIN:","");
			}
			propertyService.update(updatableProperty);
			model.addAttribute("saveinfo", "Salvestati edukalt");
			return "propertyForm";
		}

		catch(Exception ex) {
			System.out.println("ShopController.updateProduct():"+ex.getMessage());
			MyLogger.Log("ShopController.updateProduct():",ex.getMessage());
		}
		return whatView;
	}

}

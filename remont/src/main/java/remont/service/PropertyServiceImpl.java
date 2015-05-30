package remont.service;

import org.springframework.stereotype.Service;

import remont.dao.PropertyDAO;
import remont.log.MyLogger;
import remont.model.*;

import java.util.*;


@Service("productService")
public class PropertyServiceImpl implements PropertyService {
	
	private PropertyDAO propertyDAO = new PropertyDAO();


	public Property getPropertyById(Integer id) {

		Property property = null;

		try {
			property = propertyDAO.findById(id);
		} catch(Exception ex) {
			MyLogger.Log("ProductServiceImpl.getCatalogById():",ex.getMessage());
		}
		return property;
	}

	public List<Property> getProperties()  {

		List<Property> properties = new ArrayList<Property>();
		properties = propertyDAO.findAllinList();
		return properties;
	}


	public void update(Property property) {
		propertyDAO.update(property);
	}

}

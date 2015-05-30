package remont.service;
import java.util.*;

import remont.dao.PropertyDAO;
import remont.model.*;

public interface PropertyService {

	public PropertyDAO propertyDAO = new PropertyDAO(); 
	public Property getPropertyById(Integer id);
	public List<Property> getProperties();
	public void update(Property property);
}

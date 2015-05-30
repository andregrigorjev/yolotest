package property.service;
import java.util.*;

import property.dao.PropertyDAO;
import property.model.*;

public interface PropertyService {

	public PropertyDAO propertyDAO = new PropertyDAO(); 
	public Property getPropertyById(Integer id);
	public List<Property> getProperties();
	public void update(Property property);
}

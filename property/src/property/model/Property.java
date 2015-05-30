package property.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Property implements java.io.Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int propertyID ;
	@NotEmpty(message="ei tohi olla tyhi")
	@Size(max=10, message="max pikkus on 10 m2rki")
	private String type ;
	@Size(max=100, message="max pikkus on 100 m2rki")
	private String description ;
	@NotNull(message="ei tohi olla tyhi")
	@Digits(message="peab olema number", fraction = 0, integer = 10)
	@Max(value = 999, message="ei tohi olla suurem kui 999")
	private Integer rooms;

	public Property() {
	}

	public Property(int product, String name, int rooms, String description) {
		this.propertyID = product;
		this.type = name;
		this.rooms = rooms;
		this.description = description;
	}


	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription () 
	{
		return this.description ;
	}

	
	public int getPropertyID() {
		return propertyID;
	}
	
	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}
	
	public Integer getRooms() {
		return rooms;
	}
	
	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

}

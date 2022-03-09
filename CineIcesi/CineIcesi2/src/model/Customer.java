package model;

/**
 * This is the customer class, a customer has a name and an identification
 *
 */
public class Customer {
	private String name;
	private String identification;
	
	/**
	 * This is the constructor method of the customer
	 * @param name, String, this is the name of the customer
	 * @param identification, String, this is the identification number of the customer
	 */
	public Customer (String name, String identification){
		this.name = name;
		this.identification = identification;
	}
	
	/**
	 * Gets the name of the customer
	 * @return name, String, name of the customer
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the customer
	 * @param name, String, name of the customer
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the identification number of the customer
	 * @return identification, String, this is the identification number of the customer
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * Sets the identification number of the customer
	 * @param identification, String, this is the identification number of the customer
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	
	
}

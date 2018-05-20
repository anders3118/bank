/**
 * 
 */
package com.barclays.transform.model;

import java.util.List;

/**
 * @author marco.caipe
 *
 */
public class ListServices {

	/**
	 * 
	 */

	public String name;
	public List<Service> services;

	public ListServices() {
		super();
	}

	public ListServices(String name, List<Service> services) {
		super();
		this.name = name;
		this.services = services;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Service> getListServices() {
		return services;
	}

	public void setListServices(List<Service> services) {
		this.services = services;
	}

}

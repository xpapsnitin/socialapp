package com.kindson.social.location;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RestController
@Controller
public class LocationController {

	List<Location> prepareLocations() {
		Location location1 = new Location("l1", "Lagos");
		Location location2 = new Location("l2", "Asaba");
		Location location3 = new Location("l3", "Budapest");

		return Arrays.asList(location1, location2, location3);
	}

	@Autowired
	private LocationService locationService;

	/*
	 * @RequestMapping(value = "/locations") public List<Location> getAllLocations()
	 * {
	 * 
	 * // return prepareLocations(); return locationService.getAllLocations(); }
	 */

	@RequestMapping(value = "/locations")
	public String getAllLocations(Model model) {
		model.addAttribute("locations", locationService.getAllLocations());
		return "locations";
	}

	@RequestMapping(value = "/locations/name/{name}")
	public List<Location> getLocationByName(@PathVariable String name) {
		return locationService.getLocationsByName(name);
	}

	@RequestMapping(value = "/locations/{id}")
	public Optional<Location> getLocation(@PathVariable String id) {
		return locationService.getLocation(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/locations")
	public void addLocation(@RequestBody Location location) {
		locationService.addLocation(location);
	}

	@RequestMapping(value = "/location/{id}", method = RequestMethod.DELETE)
	public void deleteLocation(@PathVariable String id) {
		locationService.deleteLocation(id);
	}

	@RequestMapping(value = "/locations/{id}", method = RequestMethod.PUT)
	public void updateLocation(@RequestBody Location location, @PathVariable String id) {

		locationService.updateLocation(id, location);

	}
}

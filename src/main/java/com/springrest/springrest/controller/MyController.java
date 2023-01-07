package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.controller.entities.Place;
import com.springrest.springrest.services.PlaceService;

@CrossOrigin
@RestController
public class MyController {

	@Autowired
	private PlaceService placeService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to India !";
	}
	//get the Places
	
	@GetMapping("/places")
	public List<Place> getPlaces(){
		return this.placeService.getPlaces();
	}
	
	// single place get
	@GetMapping("/places/{placeId}")
	public Place getPlace(@PathVariable String placeId) {
		return this.placeService.getPlace(Long.parseLong(placeId));
	}
	
	// add places
	@PostMapping("/places")
	public Place addPlace(@RequestBody Place place) {
		return this.placeService.addPlace(place);
	}
	
	// update places using Put request
	@PutMapping("/places")
	public Place updatePlace(@RequestBody Place place) {
		return this.placeService.updatePlace(place);
	} 
	
	//delete places
	@DeleteMapping("/places/{placeId}")
	public ResponseEntity<HttpStatus> deletePlace(@PathVariable String placeId) {
		try {
			this.placeService.deletePlace(Long.parseLong(placeId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}

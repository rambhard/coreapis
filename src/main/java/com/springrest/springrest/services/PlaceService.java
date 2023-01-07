package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.controller.entities.Place;

public interface PlaceService {

	public List<Place> getPlaces();
	
	public Place getPlace(long placeId);
	
	public Place addPlace(Place place);
	
	public Place updatePlace(Place place);
	
	public void deletePlace(long parseLong);
		
}

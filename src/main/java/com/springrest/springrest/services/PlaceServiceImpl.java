package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.controller.entities.Place;
import com.springrest.springrest.dao.PlaceDao;

@Service
public class PlaceServiceImpl implements PlaceService {
	
	@Autowired
	private PlaceDao placeDao;
	//List<Place>list;
	
	public PlaceServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Place(101,"New Delhi","This the Captial of India"));
//		list.add(new Place(102,"Varanasi","This is a temple city"));
	}

	@Override
	public List<Place> getPlaces() {
		
		return placeDao.findAll();
	}

	@Override
	public Place getPlace(long placeId) {
		
	//	Place p = null;
//		for(Place place:list) {
//			if(place.getId()==placeId) {
//				p=place;
//				break;
//			}
//		}
		return placeDao.getOne(placeId);
	}

	@Override
	public Place addPlace(Place place) {
		//list.add(place);
		placeDao.save(place);
		return place;
	}

	@Override
	public Place updatePlace(Place place) {
//		list.forEach(e ->{
//			if(e.getId()==place.getId()) {
//				e.setTitle(place.getTitle());
//				e.setDescription(place.getDescription());
//			}
//		});
		
		placeDao.save(place);
		return place;
	}

	@Override
	public void deletePlace(long parseLong) {
		//list=this.list.stream().filter(e ->e.getId()!=parseLong).collect(Collectors.toList());
		
		Place entity = placeDao.getOne(parseLong);
		placeDao.delete(entity);
	}

}

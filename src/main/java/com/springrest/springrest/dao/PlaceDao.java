package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.controller.entities.Place;

public interface PlaceDao extends JpaRepository<Place,Long>{

}

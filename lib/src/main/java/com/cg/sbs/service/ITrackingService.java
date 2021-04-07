package com.cg.sbs.service;
import java.util.List;


public interface ITrackingService {
	

	
		Track getTrackById(Long TrackId) throws TrackNotFoundException;
		List<Track> getTracks();
		
	}




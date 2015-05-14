package io.github.tview.hoppin.service;

import io.github.tview.hoppin.model.HoppinApiRequest;

public interface HoppinService {

	public String movies(HoppinApiRequest request);
	public String seriesList(HoppinApiRequest request); 
	
}

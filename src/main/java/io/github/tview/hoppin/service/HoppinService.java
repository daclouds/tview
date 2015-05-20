package io.github.tview.hoppin.service;

import io.github.tview.hoppin.model.HoppinApiRequest;

public interface HoppinService {

	String series(HoppinApiRequest request);
	String episodes(HoppinApiRequest request, String seriesId); 
	
}

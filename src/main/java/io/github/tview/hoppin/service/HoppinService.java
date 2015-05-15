package io.github.tview.hoppin.service;

import io.github.tview.hoppin.model.HoppinApiRequest;

public interface HoppinService {

	public String series(HoppinApiRequest request);
	public String episodes(HoppinApiRequest request); 
	
}

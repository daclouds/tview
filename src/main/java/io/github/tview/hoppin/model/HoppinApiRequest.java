package io.github.tview.hoppin.model;

import lombok.Data;

@Data
public class HoppinApiRequest {

	String uri;
	Integer version = 1;
	Integer page = 1;
	Integer count = 10;
	
	String order = "";
	String genreId = "";
	
}

package io.github.tview.hoppin.model;

import lombok.Data;

@Data
public class HoppinApiRequest {

	String uri;
	Integer version;
	Integer page;
	Integer count;
	
}

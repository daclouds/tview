package io.github.tview.hoppin.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.github.tview.hoppin.model.HoppinApiRequest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class HoppinServiceImpl implements HoppinService {

	@Override
	public String series(HoppinApiRequest request) {
		Resource resource = new ClassPathResource("/static/series.json");
		String text = readTextfile(resource);
		return text.replaceAll(" ", "");
	}
	
	@Override
	public String episodes(HoppinApiRequest request) {
		Resource resource = new ClassPathResource("/static/episodes.json");
		String text = readTextfile(resource);
		return text.replaceAll(" ", "");
	}

	private String readTextfile(Resource resource) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(resource.getInputStream()), 1024);
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		return sb.toString();
	}

}

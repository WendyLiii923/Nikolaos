package com.java18.nikolaos.general.model.service.impl;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.java18.nikolaos.general.model.service.ImageService;
import com.java18.nikolaos.general.model.util.MultipartInputStreamFileResource;

@Service
public class ImageServiceImpl implements ImageService {

	private final String IMGUR_UPLOAD_URL = "https://api.imgur.com/3/upload";
	private final String IMGUR_CLIENT_ID = "9c99b6d0b6475a3";
	
	@Override
	public String upload(MultipartFile image) {
		// use REST Template to throw request and response
		RestTemplate template = new RestTemplate();
		
		// prepare for body content
		LinkedMultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		try {
			body.add("image", new MultipartInputStreamFileResource(image.getInputStream(),image.getOriginalFilename()));
		} catch (IOException e) {
//					e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		// get request entity
		URI uri = URI.create(IMGUR_UPLOAD_URL);
		RequestEntity<LinkedMultiValueMap<String, Object>> req = RequestEntity
							.post(uri)
							.header("Authorization", "Client-ID " + IMGUR_CLIENT_ID)
							.contentType(MediaType.MULTIPART_FORM_DATA)
							.body(body);
		
		// get response entity
		ResponseEntity<Map> res = template.exchange(req,Map.class);
		
		
		// check http status is 200 OK
		if(res.getStatusCodeValue() == 200) {
			String imgUrl = ((Map)res.getBody().get("Data")).get("Link").toString();
			
			return imgUrl;
		} else {
			return null;
		}
	}
	
}

package com.java18.nikolaos.general.model.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	public String upload(MultipartFile image);
}

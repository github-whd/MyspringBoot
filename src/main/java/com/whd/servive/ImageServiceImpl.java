package com.whd.servive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whd.mapper.ImageMapper;
import com.whd.model.Image;
@Service
public class ImageServiceImpl implements ImageService{
	@Autowired 
	ImageMapper imgMapper;
	public void insert(Image record) {
		imgMapper.insert(record);
	}
	
	@Override
	public Image select(String id) {
		return imgMapper.select(id);
	}
	
}

package com.whd.servive;

import com.whd.model.Image;

public interface ImageService {
	public void insert(Image record);
	Image select(String id);
}

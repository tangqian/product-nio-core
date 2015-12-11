package com.netwaymedia.nio.core.base;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.netwaymedia.nio.core.NioMain;

public class NioPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	@Override
	public void setLocation(Resource location) {
		location = rewriteResource(location);
		super.setLocation(location);
	}

	@Override
	public void setLocations(Resource... locations) {
		for (int i = 0; i < locations.length; i++) {
			locations[i] = rewriteResource(locations[i]);
		}
		super.setLocations(locations);
	}

	private Resource rewriteResource(Resource location) {
		Resource ret = location;
		if (!location.exists()) {
			String desc = location.getDescription();
			int index = desc.indexOf("root:");
			if (index != -1) {
				String fileName = desc.substring(index + 5, desc.length() - 1);
				ret = new FileSystemResource(NioMain.ROOT + fileName);
			}
		}
		return ret;
	}

}

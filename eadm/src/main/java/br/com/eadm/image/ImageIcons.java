package br.com.eadm.image;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;

public class ImageIcons {
	
	public static Resource getResourceIcon(String file){
		FileResource fileResource;
		try {
			fileResource = new FileResource(new File(ImageIcons.class.getResource("/br.com.eadm.image/"+file).getPath()));
			return fileResource;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Icon not found");
		}
		return null;
	}
}

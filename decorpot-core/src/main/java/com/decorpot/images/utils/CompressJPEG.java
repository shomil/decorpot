package com.decorpot.images.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;
import javax.imageio.ImageIO;

public class CompressJPEG {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		int i = 0;
		List<String> fileNameList = new ArrayList<String>(100);
		File file =  new File("../../../imgs_decor/Final/");
		Collection<File> files = FileUtils.listFiles(file, null, true);     
		for(File file2 : files)
		{
			fileNameList.add(file2.getName());
		    System.out.println(file2.getName());   
		    System.out.println(i++);
		} 
		for (String str : fileNameList) 
		{
			if(str != null)
			{
				File imageFile = new File("../../../imgs_decor/Final/"+str);
				
				//Check jpg file
				boolean tmp = imageFile.getName().contains(".jpg");
				System.out.println("is Jpg file = "+tmp);
				
				File compressedFile = new File("../../../imgs_decor/Final_low/"+str);
				if(tmp)
				{
					BufferedImage originalImage = ImageIO.read(imageFile);
					int width = 910;
					int height = 521;
					BufferedImage resizedImage = Scalr.resize(originalImage, width,height,Scalr.OP_ANTIALIAS,Scalr.OP_BRIGHTER);// size(originalImage, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,580, 384, Scalr.OP_ANTIALIAS);
				    ImageIO.write(resizedImage, "jpg", compressedFile);					
				}
			}
		}
	}
}

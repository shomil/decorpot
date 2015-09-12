package com.decorpot.images.compress;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class CompressJPEG {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		int i = 0;
		//String[] fileName = new String[100];
		List<String> fileNameList = new ArrayList<String>(100);
		File file =  new File("../../../imgs_decor/imagesForDecorpot");
		Collection<File> files = FileUtils.listFiles(file, null, true);     
		for(File file2 : files)
		{
			fileNameList.add(file2.getName());
		    System.out.println(file2.getName());   
		    System.out.println(i);
		} 
		for (String str : fileNameList) 
		{
			if(str != null)
			{
				File imageFile = new File("../../../imgs_decor/imagesForDecorpot/"+str);
				File compressedFile = new File("../../../imgs_decor/compressedImages/"+str);
				
				InputStream inputStream = new FileInputStream(imageFile);
				OutputStream outputStream = new FileOutputStream(compressedFile);
				float imageQuality =  0.3f;
				//Create the buffered image
				BufferedImage bufferedImage = ImageIO.read(inputStream);
				Iterator<ImageWriter> imageWriters =  ImageIO.getImageWritersByFormatName("jpg");
				
				if (!imageWriters.hasNext()){
					inputStream.close();
			        outputStream.close();
			       throw new IllegalStateException("Writers Not Found!!");
				}
				ImageWriter imageWriter = imageWriters.next();
		        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
		        imageWriter.setOutput(imageOutputStream);
		 
		        ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
		 
		        //Set the compress quality metrics
		        imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		        imageWriteParam.setCompressionQuality(imageQuality);
		 
		        //Created image
		        imageWriter.write(null, new IIOImage(bufferedImage, null, null), imageWriteParam);
		 
		        // close all streams
		        inputStream.close();
		        outputStream.close();
		        imageOutputStream.close();
		        imageWriter.dispose();
			}
		}
	}
}

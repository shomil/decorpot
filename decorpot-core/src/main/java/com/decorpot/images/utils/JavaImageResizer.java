package com.decorpot.images.utils;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This class will resize all the images in a given folder
 * 
 * @author
 *
 */
public class JavaImageResizer {

	public static void main(String[] args) throws IOException {

		File folder = new File(
				"/Users/ssaurav/Documents/imgs_decor/mani Residence/");
		File[] listOfFiles = folder.listFiles();
		System.out.println("Total No of Files:" + listOfFiles.length);
		BufferedImage img = null;
		BufferedImage tempPNG = null;
		BufferedImage tempJPG = null;
		File newFilePNG = null;
		File newFileJPG = null;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				img = ImageIO.read(new File(
						"/Users/ssaurav/Documents/imgs_decor/mani Residence/"
								+ listOfFiles[i].getName()));
				tempJPG = resizeImage(img, img.getWidth(), img.getHeight());
				newFileJPG = new File(
						"/Users/ssaurav/Documents/imgs_decor/mani residence new/"
								+ listOfFiles[i].getName());
				ImageIO.write(tempJPG, "jpg", newFileJPG);
			}
		}
		System.out.println("DONE");
	}

	/**
	 * This function resize the image file and returns the BufferedImage object
	 * that can be saved to file system.
	 */
	public static BufferedImage resizeImage(final Image image, int width,
			int height) {
		int targetw = 0;
		int targeth = 463;
		targetw = 700;
		/*
		 * if (width > height) targetw = 700; else targetw = 50;
		 */
		do {
			if (width > targetw) {
				width /= 2;
				if (width < targetw)
					width = targetw;
			}

			if (height > targeth) {
				height /= 2;
				if (height < targeth)
					height = targeth;
			}
		} while (width != targetw || height != targeth);

		final BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		final Graphics2D graphics2D = bufferedImage.createGraphics();
		graphics2D.setComposite(AlphaComposite.Src);
		graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2D.drawImage(image, 0, 0, width, height, null);
		graphics2D.dispose();

		return bufferedImage;
	}

	public BufferedImage getScaledInstance(BufferedImage img, int targetWidth,
			int targetHeight, Object hint, boolean higherQuality) {
		int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB
				: BufferedImage.TYPE_INT_ARGB;
		BufferedImage ret = (BufferedImage) img;
		int w, h;
		if (higherQuality) {
			// Use multi-step technique: start with original size, then
			// scale down in multiple passes with drawImage()
			// until the target size is reached
			w = img.getWidth();
			h = img.getHeight();
		} else {
			// Use one-step technique: scale directly from original
			// size to target size with a single drawImage() call
			w = targetWidth;
			h = targetHeight;
		}

		do {
			if (higherQuality && w > targetWidth) {
				w /= 2;
				if (w < targetWidth) {
					w = targetWidth;
				}
			}

			if (higherQuality && h > targetHeight) {
				h /= 2;
				if (h < targetHeight) {
					h = targetHeight;
				}
			}

			BufferedImage tmp = new BufferedImage(w, h, type);
			Graphics2D g2 = tmp.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
			g2.drawImage(ret, 0, 0, w, h, null);
			g2.dispose();

			ret = tmp;
		} while (w != targetWidth || h != targetHeight);

		return ret;
	}
}

package com.newgen.core.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;

public final class ImageTools {

	/****
	 * ��ȡͼƬ�?
	 * 
	 * @param imgStr
	 * @return ����һ��int[2], int[0] = width, int[1] = height;
	 * @throws Exception
	 */
	public static int[] getWidth(String imgStr) throws Exception {
		File img = new File(imgStr);
		int[] wh = new int[2];
		if (img.exists()) {
			FileInputStream fis = null;
			BufferedImage buff;
			try {
				fis = new FileInputStream(img);
				buff = ImageIO.read(fis);
				wh[0] = buff.getWidth();
				wh[1] = buff.getHeight();
				return wh;
			} catch (IOException e) {
				throw e;
			} finally {
				if (null != fis)
					fis.close();
			}
		} else {
			throw new Exception("�Ҳ���ָ���ļ�:" + imgStr);
		}
	}

	/***
	 * ͼƬѹ��
	 * 
	 * @param sourcePath
	 * @param savePath
	 * @param width
	 * @param height
	 * @param lockScale
	 * @param support
	 * @throws IOException
	 */
	public static void reSetImageSize(String sourcePath, String savePath,
			int width, int height, boolean lockScale, double support)
			throws IOException {
		ImageZoom zoom = new ImageZoom(support);
		zoom.imageZoom(sourcePath, savePath, width, height, lockScale);
	}

	/***
	 * ͼƬѹ��
	 * 
	 * @param sourceFile
	 * @param saveFile
	 * @param width
	 * @param height
	 * @param lockScale
	 * @param support
	 * @throws IOException
	 */
	public static void reSetImageSize(File sourceFile, File saveFile,
			int width, int height, boolean lockScale, double support)
			throws IOException {
		ImageZoom zoom = new ImageZoom(support);
		zoom.imageZoom(sourceFile, saveFile, width, height, lockScale);
	}

	/***
	 * ��ȡĿ��ͼƬ��ԭͼ��ѹ���ȣ�ȡ����ȵ�Сֵ��
	 * 
	 * @param width
	 *            ԭͼ��
	 * @param height
	 *            ԭͼ��
	 * @param maxWidth
	 *            Ŀ���
	 * @param maxHeight
	 *            Ŀ���
	 * @return
	 */
	private static float getRatio(int width, int height, int maxWidth,
			int maxHeight) {
		float Ratio = 1.0f;
		float widthRatio;
		float heightRatio;
		widthRatio = (float) maxWidth / width;
		heightRatio = (float) maxHeight / height;
		if (widthRatio < 1.0 || heightRatio < 1.0) {
			Ratio = widthRatio <= heightRatio ? widthRatio : heightRatio;
		}
		return Ratio;
	}


	/***
	 * ������
	 * 
	 * @param sourceFullName
	 * @param aimFullName
	 * @param maxWidth
	 * @param maxHeight
	 * @throws Exception
	 */
	public static void heightImageScale(String sourceFullName,
			String aimFullName, int maxWidth, int maxHeight) throws Exception {
		int[] wh = getWidth(sourceFullName);// ��ȡԭͼ���
		int width = wh[0];
		int height = wh[1];
		if (maxHeight > height && maxWidth > width) {
			System.out.println("the arm image size bigger than source image");
			//ͼƬ����һ��
			FileTools.copy(sourceFullName, aimFullName);
			return;
		}
		float wp = (float)maxWidth / width;
		float hp = (float)maxHeight / height;
		float p = wp > hp ? hp : wp;//ȡС��
		
		//����С�ȣ����Ŀ�� ͼƬ �Ŀ��
		maxHeight = (int) (p * height);
		maxWidth = (int) (p * width);
		
		Builder<BufferedImage> bf = null;
		File sourceFile = new File(sourceFullName);
		BufferedImage oldBi = ImageIO.read(sourceFile);
		
		// ��ͼ
		if ((float) maxWidth
				/ maxHeight != (float) width
				/ height) {
			if (width < height) {
				oldBi = Thumbnails.of(sourceFile)
						.height(maxHeight)
						.asBufferedImage();
			} else {
				oldBi = Thumbnails.of(sourceFile)
						.width(maxWidth)
						.asBufferedImage();
			}
			bf = Thumbnails
					.of(oldBi)
					.sourceRegion(Positions.CENTER,
							maxWidth,
							maxHeight)
					.size(maxWidth,
							maxHeight);
		} else {
			bf = Thumbnails.of(oldBi).size(maxWidth,
					maxHeight);
		}
		
	/*	
		oldBi = Thumbnails.of(sourceFile)
				.height(maxHeight)
				.asBufferedImage();
		bf = Thumbnails.of(oldBi)
				.sourceRegion(Positions.CENTER,
						maxWidth,
						maxHeight)
				.size(maxWidth,
						maxHeight);*/
		bf.toFile(aimFullName);
	}

}

package com.newgen.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public final class FileTools {
	/***
	 * ���ļ�����
	 * 
	 * @param sourcePath
	 * @param dirPath
	 * @return
	 * @throws IOException
	 */
	public static boolean move(String sourcePath, String dirPath)
			throws IOException {
		File sourceFile = new File(sourcePath);
		exists(dirPath, true);
		sourceFile.renameTo(new File(dirPath));
		return true;
	}

	/***
	 * �����ļ�
	 * 
	 * @param sourcePath
	 * @param savePath
	 * @throws Exception
	 */
	public static void copy(String sourcePath, String savePath)
			throws Exception {
		File sourceFile = new File(sourcePath);
		if (sourceFile.exists()) {
			exists(savePath, true);
			InputStream inStream = new FileInputStream(sourceFile);
			FileOutputStream fos = new FileOutputStream(savePath);
			byte[] buff = new byte[1024 * 1024];// ��1M�Ļ���
			int length = 0;
			while ((length = inStream.read(buff)) != -1) {
				fos.write(buff, 0, length);
			}
			inStream.close();
			fos.flush();
			fos.close();
		} else {
			//throw new Exception("the file is not exist");
			System.out.println("the file is not exist");
		}
	}

	/***
	 * �ж��ļ��Ƿ���ڣ������ڣ��򴴽��ģ������ڣ���ɸ��isDelete ״̬�������ļ�ɾ��
	 * 
	 * @param path
	 * @param isDelete
	 *            �Ƿ������ļ�ɾ��
	 */
	public static void exists(String path, boolean isDelete) {
		File dirFile = new File(path);
		if (!dirFile.exists()) {
			String floder = path.substring(0, dirFile.getAbsolutePath().lastIndexOf("\\") + 1);
			File floderFile = new File(floder);
			if (!floderFile.exists())
				floderFile.mkdirs();
		} else if (isDelete)
			dirFile.delete();
	}

	/***
	 * ɾ���ļ����ļ�
	 * 
	 * @param path
	 */
	public static void delete(String path) {
		File file = new File(path);
		if (file.exists()) {// ����ļ�����
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File f : files) {
					if (f.isDirectory())
						delete(f.getAbsolutePath());
					else if (f.isFile())
						f.delete();
					else if (f.isAbsolute())
						f.delete();
				}
			}
			file.delete();
		}
	}
	
	/***
	 * ���ʱ�䣬�������ļ���
	 * @param sourceFileName ԭ�ļ���
	 * @param currentTime ���ʱ��
	 * @return
	 * @throws Exception
	 */
	public static String getRandomName(String sourceFileName, Date currentTime) throws Exception{
		StringBuilder rName = new StringBuilder();
		rName.append(currentTime.getTime())
		.append(getRandomNumber(6))
		.append(getFileExt(sourceFileName));
		return rName.toString();
	}
	
	/**
	 * ��ݵ�ǰʱ�䣬�������ļ���
	 * @param sourceFileName
	 * @return
	 * @throws Exception
	 */
	public static String getRandomName(String sourceFileName) throws Exception{
		return getRandomName(sourceFileName, new Date());
	}
	
	/***
	 * ��ȡ�ļ���׺��.jpg��
	 * @param fileName
	 * @return
	 */
	public static String getFileExt(String fileName){
		if(fileName.indexOf('.')>=0){
			return fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
		}else
			return "";
	}
	
	/**
	 * ���18λ�����ڵ������
	 * @param num
	 * @return
	 * @throws Exception 
	 */
	public static long getRandomNumber(int num) throws Exception{
		if(num>18 || num <1)
			throw new Exception("�����λ��1-18λ֮��");
		else{
			num -= 1;
			long min = (long) Math.pow(10, num);
			long max = (long) Math.pow(10, num+1) - 1 - min;
			
			return (long) (Math.random() * max + min);
		}
	}
}

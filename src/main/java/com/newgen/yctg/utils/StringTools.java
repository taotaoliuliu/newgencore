package com.newgen.yctg.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * �����ṩ��String���һЩ���÷���
 */
public final class StringTools {
	/***
	 * �ж��ַ���ΪNull �� ���ַ�
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		return null == str || "".equals(str);
	}

	/***
	 * ISO �����ַ�תΪ UTF-8
	 * 
	 * @param isoStr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String iso2UTF8(String isoStr)
			throws UnsupportedEncodingException {
		return StrTranscoding(isoStr, "iso8859-1", "utf-8");
	}

	/**
	 * UTF8 �����ַ�תΪ ISO8859-1
	 * 
	 * @param utfStr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String utf2ISO(String utfStr)
			throws UnsupportedEncodingException {
		return StrTranscoding(utfStr, "utf-8", "iso8859-1");
	}

	/***
	 * �ַ����ת��
	 * 
	 * @param str
	 *            Դ�ַ�
	 * @param sourceCoding
	 *            ��ǰ�ַ����
	 * @param dirCoding
	 *            Ŀ���ַ����
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String StrTranscoding(String str, String sourceCoding,
			String dirCoding) throws UnsupportedEncodingException {
		byte[] bytes = str.getBytes(sourceCoding);
		return new String(bytes, dirCoding);
	}

	/**
	 * ������תΪָ����ʽ���ַ�
	 * @param date
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static String getDateString(Date date, String format) throws Exception {
		try {
			SimpleDateFormat fm = new SimpleDateFormat(format);
			return fm.format(date);
		} catch (Exception e) {
			Exception ex = new Exception("����ת�ַ�ʱ����\n" + e.getMessage());
			throw ex;
		}
	}
	
	/**
	 * MD5 ����
	 * @param s
	 * @return
	 */
	public static String md5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] btInput = s.getBytes();
			// ���MD5ժҪ�㷨�� MessageDigest ����
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// ʹ��ָ�����ֽڸ���ժҪ
			mdInst.update(btInput);
			// �������
			byte[] md = mdInst.digest();
			// ������ת����ʮ����Ƶ��ַ���ʽ
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e){
			return null;
		}
	}
	
	/**
	 * ������ʾ��֤
	 * @param str Ҫ��֤���ַ�
	 * @param reg ������ʾ
	 * @return
	 */
	public static boolean validate(String str, String reg){
		if(null == str)
			return false;
		return str.matches(reg);
	}

	/***
	 * �����ͬ 001�� 012���ַ� ��������
	 * @param num ��Ȼ��
	 * @param count λ��
	 * @return �8λ��
	 */
	public static String getStringNum(int num, int count){
		if(count>8)
			count = 8;
		if(count<0)
			count = 0;
		int max = (int) Math.pow(10, count);
		if(num>max)
			return num + "";
		else{
			StringBuilder strNum = new StringBuilder();
			for(int i=1;i<=count;i++){
				if(max/num==0){
					strNum.append(0);
				}else{
					strNum.append(num);
					break;
				}
				max/=10;
			}
			return strNum.toString();
		}
	}
}

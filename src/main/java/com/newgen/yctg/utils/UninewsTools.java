package com.newgen.yctg.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UninewsTools
{


//	private static CmsConnection conn=null;
//	private static Statement stmt = null;
//	private static ResultSet rs = null;



    public static String nnString(String inputString)
    {
        String outputString = inputString == null ? "" : inputString;
        return outputString;
    }


//�û��������
    public static String encryptPassword(String password)
    {
        //if(password == null)
        //    return null;
        //if(password.length() == 0)
        //    return null;
        String result = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            if(md != null)
            {
                md.reset();
                if(password!=null)
                {
                	md.update(password.getBytes());
                	
                }
           
                result = new String(Base64.encode(md.digest()));
            }
            md = null;
        }
        catch(NoSuchAlgorithmException _ex)
        {
            result = null;
        }
        return result;
    }



	    //�ж��ַ��Ƿ�Ϸ���ֻ������ĸ�����ֺ��»��ߣ�
    public static boolean isAlphaValid(String name)
    {
        if(name == null)
            return false;
        if(name.length() == 0)
            return false;
        String authorizedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";
        char chars[] = authorizedCharacters.toCharArray();
        char nameBuffer[] = name.toCharArray();
        boolean badCharFound = false;
        for(int i = 0; i < nameBuffer.length && !badCharFound; i++)
        {
            int j = 0;
            boolean ok;
            for(ok = false; j < chars.length && !ok; j++)
                if(chars[j] == nameBuffer[i])
                    ok = true;

            badCharFound = ok ^ true;
            if(badCharFound)
                System.out.println("UninewsTools.isAlphaValid >> --/ Bad character found in [" + name + "] at position " + Integer.toString(i));
        }

        return badCharFound ^ true;
    }

    //�ж��û���������Ƿ���ȷ
//    public static boolean verifyPassword(String username, String password)
//    {
//    	boolean ok = false;
//        if(username !=null && password != null)
//        {
//    		String test = encryptPassword(password);
//    		try{
//    		    conn = CmsPool.getInstance().connect();
//    		    stmt = conn.getOriginalConnection().createStatement();
//    		    String strsql="select * from userInfo where name_Login='"+ username +"' and password='"+ test +"'";
//    		    rs = stmt.executeQuery(strsql);
//    		    if(rs.next()){
//    		    	System.out.println("user:" + username + " verify password ok.");
//    		    	ok = true;
//    		    }
//    		}catch(SQLException e){System.out.println("Error" + e.toString());}
//    		finally{
//    		try{
//    		    rs.close();
//    		    stmt.close();
//    		    conn.close();
//    		}
//    		catch(SQLException e){System.out.println("Error" + e.toString());}
//    		}
//
//            if (ok)
//            {
//            	return true;
//            }
//            else
//            {
//            	return false;
//            }
//
//        } else
//        {
//            return false;
//        }
//    }


	//get datetime now
    public static String strNowtime(){
    	String dateString="";
    	try{
    	java.text.SimpleDateFormat formatter= new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
    	Date currentTime_1 = new Date();
    	dateString = formatter.format(currentTime_1);
    	}catch(Exception e){
    	     }
    	 return dateString;
     }

     public static String strNowtime1(){
             String dateString="";
             try{
             java.text.SimpleDateFormat formatter= new SimpleDateFormat ("yyyyMMdd");
             Date currentTime_1 = new Date();
             dateString = formatter.format(currentTime_1);
             }catch(Exception e){
                  }
              return dateString;
      }


	 //
	 public static void copyFiles(String oldFilename,String newFileName,String dirStr)
	{
		// Copy Files
    	boolean error = false;
        try {
          	byte buffer[] = new byte[0xffff];
			File f_old = new File(oldFilename);
			File f_new = new File(dirStr);

			if (f_old.exists())
			{
				if (!f_new.exists())
					f_new.mkdirs();

				f_new = new File(newFileName);

				if (!f_new.exists())	//����ļ������ڣ����и��Ʋ���
					copyStreams(new FileInputStream(f_old), new FileOutputStream(f_new), buffer);
			}
		}
		catch (IOException e) {
			System.out.println("copy file error.>>" + e.toString());
		}

	}

		public static void copyStreams(InputStream in, OutputStream out, byte[] buffer) throws IOException {
		copyStreamsWithoutClose(in, out, buffer);
		in.close();
		out.close();
	}
	public static void copyStreamsWithoutClose(InputStream in, OutputStream out, byte[] buffer)
			throws IOException {
		int b;
		while ((b = in.read(buffer)) != -1)
			out.write(buffer, 0, b);
	}

	public String Mkdir(String path)
	 {
		String msg=null;
		try {
		java.io.File dir;

		// �½��ļ�����
		dir = new java.io.File(path);
		if (dir == null){
		msg = "����ԭ��:��BR���Բ��𣬲��ܴ�����Ŀ¼��";
		return msg;
		}
				if(dir.isFile())
				{
				msg = "����ԭ��:��BR������ͬ���ļ���B��" + dir.getAbsolutePath() + "��/B�����ڡ�";
				return msg;
				}
				if(!dir.exists())
				{
				boolean result = dir.mkdirs();
				if (result == false) {
				msg = "����ԭ��:��BR��Ŀ¼��b��" + dir.getAbsolutePath() + "��/B������ʧ�ܣ�ԭ������";
				return msg;
				}
				return msg;
				}
				else {
				msg = "����ԭ��:��BR��Ŀ¼��b��" + dir.getAbsolutePath() + "��/b���Ѵ��ڡ�";
				}
				return msg;
			} catch (Exception e){
				System.out.println(msg);
				System.out.println("Error : " + e.toString());
				return msg;
			}

	}

}
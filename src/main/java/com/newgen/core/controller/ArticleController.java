package com.newgen.core.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.newgen.core.bean.Article;
import com.newgen.core.bean.ArticleData;
import com.newgen.core.bean.Category;
import com.newgen.core.bean.User;
import com.newgen.core.plugin.PageView;
import com.newgen.core.service.ArticleService;
import com.newgen.core.service.CategoryService;
import com.newgen.core.utils.ImageTools;
import com.newgen.core.utils.ManagerPro;

import com.newgen.yctg.utils.DateUtil;
import com.newgen.yctg.utils.PageUtil;
import com.newgen.yctg.utils.StringTools;
@RequestMapping("/cms")
@Controller
public class ArticleController {
			@Autowired
			ArticleService articleService;
			
			@Autowired
			CategoryService categoryService;

	@RequestMapping("/getArtilceByCategory")
	public String getArtilceByCategory(HttpServletRequest request,Article article,
			String pageNow,String pageSize,Model model)
	{
		
	// model.
		
//String infocontent=request.getParameter("infocontent");
		/*
		System.out.println(infocontent);
		
		String ctype=request.getParameter("ctype");
		
		model.addAttribute("infocontent", infocontent);
		model.addAttribute("ctype", ctype);*/
		
		
		
PageView<Article> pageview=	articleService.getPageList(PageUtil.getPageView(pageNow, pageSize),article);


List<Article> records = pageview.getRecords();


for(Article a :records){
	
	String categoryid = a.getCategoryid();
	if(categoryid!=null)
	{
		Category category = categoryService.getById(categoryid);
		
		a.setCategory(category);
		
	}
}

		
		model.addAttribute("pageview",pageview);
		model.addAttribute("article", article);
		
	
		return "cms/listArticle";
	}
	
	
	@RequestMapping("/addArticleUI")
	public String addArticleUI(){
		
		
		
		
		
		
		return "cms/addArticle";
	}
	
	
	
	@RequestMapping("/save")
	public String save(Article article,HttpServletRequest request,HttpServletResponse response,RedirectAttributes model){
		
		
		String infocontent="";
		
		String ctype="";
		try {
			
		
			
			User user=(User)request.getSession().getAttribute("user");
			
			String content = request.getParameter("content");
			
			String articleid = UUID.randomUUID().toString().replace("-", "");
			
			article.setId(articleid);
			
			article.setCreatetime(DateUtil.formatDateTime(new Date()));
			
			article.setUpdatetime(DateUtil.formatDateTime(new Date()));
			
			
			article.setEditorid(user.getId());
			
			article.setAuthorid(user.getId());
			
			articleService.add(article);
			
			ArticleData articleData =new ArticleData();	
			
			articleData.setArticleid(articleid);
			articleData.setContent(content);
			
			articleData.setAllowcomment("1");
			
			articleService.saveArticleData(articleData);
			model.addFlashAttribute("infocontent", "保存成功！");
			model.addFlashAttribute("ctype", "success");
			
		} catch (Exception e) {
			
			ctype="error";
			infocontent= "保存失败！";
			e.printStackTrace();
		}
		
		
		return "redirect:/cms/getArtilceByCategory.do?infocontent="+infocontent+"&ctype="+ctype+"";
	}
	
	@RequestMapping("/delete")
	public String delete(String articleid,RedirectAttributes  model){
		

		try {
			articleService.delete(articleid);
			
			model.addFlashAttribute("infocontent", "删除成功！");
			model.addFlashAttribute("ctype", "success");
			


		
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
		}
		
		
		
		
		return "redirect:/cms/getArtilceByCategory.do";
 
	}
	
	@RequestMapping("/updateUI")
	public String updateUI(String articleid,Model model){
		
		
		Article article = articleService.getById(articleid);
		
		
		ArticleData articleData = articleService.getArticleData(articleid);
		
		String categoryid = article.getCategoryid();
		
		if(categoryid!=null)
		{
			
			Category category = categoryService.getById(article.getCategoryid());
			
			article.setCategory(category);

			
		}
		
		
		article.setArticleData(articleData);
		
		
		model.addAttribute("article", article);
		model.addAttribute("imgServerPath", ManagerPro.getString("imgServerPath"));
		
		return "cms/updateArticle";
	}
	@RequestMapping("/update")
	public String update(Article article,HttpServletRequest request,RedirectAttributes model) throws Exception{
		
		
		
String infocontent="";
		
		String ctype="";
		
		try {
			String content = request.getParameter("content");
			
			article.setUpdatetime(DateUtil.formatDateTime(new Date()));
			
			User user=(User)request.getSession().getAttribute("user");

			
			article.setEditorid(user.getId());
			
			articleService.update(article);
			
			ArticleData articleData=	articleService.getArticleData(article.getId());
			
			articleData.setContent(content);
			
			articleService.updateArticleData(articleData);
			
			model.addFlashAttribute("infocontent", "修改成功！");
			model.addFlashAttribute("ctype", "success");
			
		} catch (Exception e) {
			
			ctype="error";
			infocontent= "保存失败！";
			e.printStackTrace();
		}
		
		
		
		
		
		
		return "redirect:/cms/getArtilceByCategory.do?infocontent="+infocontent+"&ctype="+ctype+"";

	}
	
	@RequestMapping("/deleteFile")
	public String deleteFile(HttpServletResponse response)
	{
		
		JSONObject jsonObject = new JSONObject();

		try {
			jsonObject.put("msg", "删除成功");
			
			jsonObject.put("ret", 1);

			response.getWriter().println(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		
		JSONObject jsonObject = new JSONObject();

		
		try {
			
			MultipartFile filedata=null;
			
		       //创建一个通用的多部分解析器   
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
			
	        
	        if(multipartResolver.isMultipart(request)){  
	        	
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request; 
	        Iterator<String> iter = multiRequest.getFileNames();  
	        
	        while(iter.hasNext()){  
	        	
	        	
                 filedata = multiRequest.getFile(iter.next());  

	        	
	        }
	        }
			
			if ( null != filedata) {

				
				// 取文件扩展名
				String fileExt = filedata.getOriginalFilename().substring(
						filedata.getOriginalFilename().lastIndexOf('.') + 1).toLowerCase();
				String fileRoot = ManagerPro.getString("imgSavePath");
				String path = "/picture/"
						+ StringTools.getDateString(new Date(), "yyyyMMdd");
				
				jsonObject.put("filepath", path);
				String name = UUID.randomUUID().toString() + "." + fileExt;
				
				jsonObject.put("filename", name);

				
				
				System.out.println(fileRoot);
				if ("jpg | png | gif | bmp".indexOf(fileExt) >= 0) {// 图片文件
					File LagerImg = new File(fileRoot + path + "/L_" + name);
					
					
				if(	!LagerImg.exists()){
					
					
					LagerImg.mkdirs();
				}
				 
				String ssize = ManagerPro.getString("SSize");
				String msize = ManagerPro.getString("MSize");
					
					// 保存源图
					//FileUtils.copyFile(filedata, LagerImg);
					
					filedata.transferTo(LagerImg);
					// 生成中图
					try{
					ImageTools.heightImageScale(LagerImg.getAbsolutePath(),
							fileRoot + path + "/M_" + name, Integer.parseInt(msize),
							Integer.parseInt(msize));
					}catch(Exception e){
						e.printStackTrace();
					}
					// 生成小图
					
				
					
					ImageTools.heightImageScale(LagerImg.getAbsolutePath(),
							fileRoot + path + "/S_" + name, Integer.parseInt(ssize),
							Integer.parseInt(ssize));
					int[] wh = ImageTools.getWidth(LagerImg.getAbsolutePath());
				} else {
					// 保存其他文件
					File file = new File(fileRoot + path + "/" + name);
//					/FileUtils.copyFile(filedata, file);
					
					filedata.transferTo(file);

					if ("mp4".equals(fileExt)){
					}
					else if ("mp3".equals(fileExt)){
					}
				}
				// 存入数据库

	
				
				

			} 
			
			jsonObject.put("msg", "sucess");
			
		} catch (Exception e) {
			
			jsonObject.put("msg", "fail");

			e.printStackTrace();
		}
		
		try {
			response.getWriter().println(jsonObject.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
}

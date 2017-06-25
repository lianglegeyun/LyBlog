package com.ly.blog.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ly.blog.dao.bean.dto.VistorDTO;
import com.ly.blog.dao.bean.impl.Article;
import com.ly.blog.dao.bean.impl.Vistor;
import com.ly.blog.service.BlogService;
import com.ly.blog.service.VistorService;
import com.ly.blog.web.util.JsonUtil;
import com.ly.blog.web.util.PagerUtil;

@Controller
public class AdminController {
	
	private static final int VISTORPAGESIZE = 20;
	private static final int PAGERCOUNT = 5;
	
	@RequestMapping(value="/admin")
	public ModelAndView adminAction(HttpServletRequest request) throws Exception{
		//
		ModelAndView model = new ModelAndView("admin");
		List<Article> articleList = BlogService.getAllArticles();
		model.addObject("articleList", articleList);
		
		//
		String pageStr = request.getParameter("page");
		int page = StringUtils.isEmpty(pageStr) ? 1 : Integer.valueOf(pageStr);
		List<Vistor> vistorList = VistorService.getPagingVistors(page, VISTORPAGESIZE);
		model.addObject("vistorList", vistorList);
		
		int total = VistorService.getVistCount();
		List<String> pager = PagerUtil.getPager(total, VISTORPAGESIZE, PAGERCOUNT, page);
		
		model.addObject("pager", pager);
		//
		int yesterdayVistorCount = VistorService.getYesterdayVistorCount();
		model.addObject("yesterdayVistorCount", yesterdayVistorCount);
		
		return model;
	}
	
	@RequestMapping(value="/admin",params="method=edit")
	public ModelAndView editArticleAction(HttpServletRequest request){
		ModelAndView model = new ModelAndView("edit");
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			Article article = BlogService.getArticle(Integer.valueOf(id));
			model.addObject("article", article);
		}
		return model;
	}
	
	@RequestMapping(value="/admin",params="method=backToArticleList")
	public ModelAndView backToArticleListAction(HttpServletRequest request){
		ModelAndView model = new ModelAndView("articleList");
		List<Article> articleList = BlogService.getAllArticles();
		model.addObject("articleList", articleList);
		return model;
	}
	
	@RequestMapping(value="/admin",params="method=save")
	public void saveAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String excerpt = request.getParameter("excerpt");
		String content = request.getParameter("content");
		String isPrivate = request.getParameter("isPrivate");
		
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setExcerpt(excerpt);
		article.setContent(content);
		article.setStatus( Boolean.valueOf(isPrivate) ? 0 : 1);
		article.setLastUpdateTime(new Date());
		
		if(StringUtils.isEmpty(id)){
			BlogService.addArticle(article);
		}else{
			BlogService.updateArticle(article);
		}
		JsonUtil.writeSuccessData(response, "\"id\":" + article.getId());
	}
	
	@RequestMapping(value="/admin",params="method=delete")
	public ModelAndView deleteAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			BlogService.deleteArticle(id);
			return backToArticleListAction(request);
		}else{
			throw new Exception("id is empty!");
		}
		
	}
	
	@RequestMapping(value="/admin",params="method=vistorPage")
	public ModelAndView vistorPageAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView model = new ModelAndView("vistDetails");
		String pageStr = request.getParameter("page");
		int page = StringUtils.isEmpty(pageStr) ? 1 : Integer.valueOf(pageStr);
		List<Vistor> vistorList = VistorService.getPagingVistors(page, VISTORPAGESIZE);
		model.addObject("vistorList", vistorList);
		//
		int total = VistorService.getVistCount();
		List<String> pager = PagerUtil.getPager(total, VISTORPAGESIZE, PAGERCOUNT, page);
		model.addObject("pager", pager);
		return model;
		
	}
	
	
	@RequestMapping(value="/admin",params="method=vistorInfo")
	public ModelAndView vistorInfoAction() throws Exception{
		ModelAndView model = new ModelAndView("vistorInfo");
		List<VistorDTO> vistors = VistorService.getVistor();
		model.addObject("vistorList", vistors);
		return model;
	}
	
	@RequestMapping(value="/admin",params="method=updateAddr")
	public ModelAndView updateAddrAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		VistorService.batchUpdateVistorAddr();
		return vistorPageAction(request, response);
	}
	
	@RequestMapping(value="/admin/uploadImg")
	public void uploadImgAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String savePath = uploadFile(request);
		String jsonStr = "\"url\" : \"" + savePath + "\"";
		JsonUtil.writeSuccessData(response, jsonStr);
		
	}
	
	private String uploadFile(HttpServletRequest request){
		String savePath = request.getRealPath("/upload");
		File file = new File(savePath);
        if(!file.exists()&&!file.isDirectory()){
            file.mkdir();
        }
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		fileUpload.setHeaderEncoding("UTF-8");
		if(!ServletFileUpload.isMultipartContent(request)){
            return null;
        }
		String fileName = null;
		try {
			List<FileItem> list = fileUpload.parseRequest(request);
			for (FileItem item : list) {
				if( !item.isFormField()){
					fileName = item.getName();
					if(fileName==null||fileName.trim().equals("")){
                        continue;
                    }
					fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
					InputStream is = item.getInputStream();
					FileOutputStream fos = new FileOutputStream(savePath + File.separator + fileName);
					byte buffer[] = new byte[1024];
					int length = 0;
					while((length = is.read(buffer))>0){
                        fos.write(buffer, 0, length);
                    }
					is.close();
					fos.close();
					item.delete();
				}
			}
			return request.getContextPath() + "/upload/" + fileName;
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

}

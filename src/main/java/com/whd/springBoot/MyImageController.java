package com.whd.springBoot;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.whd.model.Image;
import com.whd.model.Response;
import com.whd.servive.ImageService;
import com.whd.util.FtpUtil;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
@Controller
public class MyImageController {
	@Autowired
	ImageService imgService;
	@RequestMapping(value="/upLoadImg")
	public String upLoadImg() {
		return "image";
	}
	@RequestMapping(value="/inserImg", method = RequestMethod.POST)
	public void inserImg( HttpServletRequest request,HttpServletResponse response, @RequestParam("img") MultipartFile file ) throws IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String id  = request.getParameter("id");
			System.out.println(id);
			if(!file.isEmpty()){
				BASE64Encoder encoder = new BASE64Encoder();
				//通过base64来转化图片
				String img = encoder.encode(file.getBytes());
				Image record = new Image();
				record.setId(id);
				record.setImg(img);
				imgService.insert(record);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//上传图片到FTP
	@RequestMapping(value="/inserImgFtp", method = RequestMethod.POST)
	public void inserImgFtp( HttpServletRequest request,HttpServletResponse response, @RequestParam("img") MultipartFile file ) throws IOException {
		InputStream inputStream = file.getInputStream();
		//家里IP:192.168.1.4
		FtpUtil.uploadFile("172.20.10.4", 21, "newuser", "123456", "/", "/2016/11", "123.jpg", inputStream);
	}	//从FTP上下载图片并转化为Base64
	@RequestMapping(value="/getImgFtp", method = RequestMethod.GET)
	public Response getImgFtp() throws IOException {
		
		return FtpUtil.downloadFile("192.168.1.4", 21, "newuser", "123456",  "/sad/2016/11", "211.jpg", "I:/mylocalftp");
	}
	@RequestMapping(value="/getImg", method = RequestMethod.GET)
	public void getImg( HttpServletRequest request,HttpServletResponse response, String id ) throws IOException {
		Image img = imgService.select(id);
		byte[] byteAry = (byte[])img.getImg();
		String data = new String(byteAry, "utf-8");
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = decoder.decodeBuffer(data);
		for (int i = 0; i < bytes.length; i++) {
			if(bytes[i] < 0){
				bytes[i] += 256;
			}
		}
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		out.write(bytes);
		out.flush();
		out.close();
	}
}

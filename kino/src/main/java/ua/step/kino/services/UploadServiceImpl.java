package ua.step.kino.services;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("UploadService")
public class UploadServiceImpl implements UploadService {

	String uploadImagePath = "http://mick9045.000webhostapp.com/upload.php";
	
	
	String crlf = "\r\n";
	String twoHyphens = "--";
	String boundary =  "*****";
	
	URL url;
	public UploadServiceImpl() throws MalformedURLException {
	url	= new URL(uploadImagePath);
	}
	
	
	private int uploadImage(MultipartFile file, String attachmentName, String attachmentFileName) {
		
		if(attachmentFileName == null)
		attachmentFileName = file.getOriginalFilename();
		
		HttpURLConnection con;
		try {
			
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "multipart/form-data");
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Cache-Control", "no-cache");
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setRequestProperty(
				    "Content-Type", "multipart/form-data;boundary=" + boundary);

			DataOutputStream request = new DataOutputStream(
					con.getOutputStream());

				request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
				request.writeBytes("Content-Disposition: form-data; name=\"" +
				    attachmentName + "\";filename=\"" + 
				    attachmentFileName + "\"" + this.crlf);
				request.writeBytes(this.crlf);
				request.write(file.getBytes());
				request.writeBytes(this.crlf);
				request.writeBytes(this.twoHyphens + this.boundary + 
				    this.twoHyphens + this.crlf);
				request.flush();
				request.close();
				
				
				int response = con.getResponseCode();
				
				con.disconnect();
				
				return response;

					
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	private int uploadBytes(byte[] file, String attachmentName, String attachmentFileName) {
		
		
		
		HttpURLConnection con;
		try {
			
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "multipart/form-data");
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Cache-Control", "no-cache");
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setRequestProperty(
				    "Content-Type", "multipart/form-data;boundary=" + boundary);

			DataOutputStream request = new DataOutputStream(
					con.getOutputStream());

				request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
				request.writeBytes("Content-Disposition: form-data; name=\"" +
				    attachmentName + "\";filename=\"" + 
				    attachmentFileName + "\"" + this.crlf);
				request.writeBytes(this.crlf);
				request.write(file);
				request.writeBytes(this.crlf);
				request.writeBytes(this.twoHyphens + this.boundary + 
				    this.twoHyphens + this.crlf);
				request.flush();
				request.close();
				
				
				int response = con.getResponseCode();
				
				con.disconnect();
				
				return response;

					
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		
		return 0;
	}



	@Override
	public int uploadBigPoster(MultipartFile file) {
		
		return uploadImage(file, "bigposter", null);
	}


	@Override
	public int uploadSmallPoster(MultipartFile file) {
		return uploadImage(file, "smallposter", null);
	}


	@Override
	public int uploadBigPortrait(MultipartFile file) {

		return uploadImage(file, "bigportrait", null);
	}


	@Override
	public int uploadSmallPortrait(MultipartFile file) {

		return uploadImage(file, "smallportrait", null);
	}
	
	@Override
	public int uploadBigPoster(MultipartFile file, String attachmentFileName) {
		
		return uploadImage(file, "bigposter", attachmentFileName);
	}


	@Override
	public int uploadSmallPoster(MultipartFile file, String attachmentFileName) {
		return uploadImage(file, "smallposter", attachmentFileName);
	}


	@Override
	public int uploadBigPortrait(MultipartFile file, String attachmentFileName) {

		return uploadImage(file, "bigportrait", attachmentFileName);
	}


	@Override
	public int uploadSmallPortrait(MultipartFile file, String attachmentFileName) {

		return uploadImage(file, "smallportrait", attachmentFileName);
	}
	
	@Override
	public int uploadBigPoster(byte[] file, String attachmentFileName) {
		
		return uploadBytes(file, "bigposter", attachmentFileName);
	}


	@Override
	public int uploadSmallPoster(byte[] file, String attachmentFileName) {
		return uploadBytes(file, "smallposter", attachmentFileName);
	}


	@Override
	public int uploadBigPortrait(byte[] file, String attachmentFileName) {

		return uploadBytes(file, "bigportrait", attachmentFileName);
	}


	@Override
	public int uploadSmallPortrait(byte[] file, String attachmentFileName) {

		return uploadBytes(file, "smallportrait", attachmentFileName);
	}
	

}

package ua.step.kino.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService{
	
	public int uploadBigPoster(MultipartFile file);
	public int uploadSmallPoster(MultipartFile file);
	public int uploadBigPortrait(MultipartFile file);
	public int uploadSmallPortrait(MultipartFile file);
	public int uploadSmallPortrait(MultipartFile file, String attachmentFileName);
	public int uploadBigPortrait(MultipartFile file, String attachmentFileName);
	public int uploadSmallPoster(MultipartFile file, String attachmentFileName);
	public int uploadBigPoster(MultipartFile file, String attachmentFileName);
	public int uploadBigPoster(byte[] file, String attachmentFileName);
	public int uploadSmallPoster(byte[] file, String attachmentFileName);
	public int uploadBigPortrait(byte[] file, String attachmentFileName);
	public int uploadSmallPortrait(byte[] file, String attachmentFileName);
	
}
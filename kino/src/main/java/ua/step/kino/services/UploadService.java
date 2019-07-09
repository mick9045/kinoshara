package ua.step.kino.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService{
	
	public int uploadBigPoster(MultipartFile file);
	public int uploadSmallPoster(MultipartFile file);
	public int uploadBigPortrait(MultipartFile file);
	public int uploadSmallPortrait(MultipartFile file);
	
}
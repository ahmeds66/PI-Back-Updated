package com.us.theatre.service.play;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.us.theatre.entities.play.PlayImage;
import com.us.theatre.repos.PlayImageRepository;

@Service
public class PlayImageServiceImpl implements PlayImageService{
	@Autowired
	PlayImageRepository imageRepository;
	 
	 
	 
	@Autowired
	PlayService playService;
	 
	 
	 
	 
	 @Override
	 public PlayImage uplaodImage(MultipartFile file) throws IOException {
		 return 
				 imageRepository.save(PlayImage.builder()
				 .name(file.getOriginalFilename())
				 .type(file.getContentType())
				 .image(file.getBytes()).build());
	 }
	 @Override
	 public PlayImage getImageDetails(Long id) throws IOException{
		 final Optional<PlayImage> dbImage = imageRepository.findById(id);
		 return 
				 PlayImage.builder()
				 .idImage(dbImage.get().getIdImage())
				 .name(dbImage.get().getName())
				 .type(dbImage.get().getType())
				 .image(dbImage.get().getImage()).build();
	 }
	 @Override
	 public ResponseEntity<byte[]> getImage(Long id) throws IOException{
		 final Optional<PlayImage> dbImage = imageRepository.findById(id);
		 return 
				 ResponseEntity
				 .ok()
				 .contentType(MediaType.valueOf(dbImage.get().getType()))
				 .body(dbImage.get().getImage());
	 }
	 @Override
	 public void deleteImage(Long id) {
		 imageRepository.deleteById(id);
	 }
}

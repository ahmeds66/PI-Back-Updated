package com.us.theatre.service.actor;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.us.theatre.entities.actor.ActorImage;
import com.us.theatre.repos.ActorImageRepository;
import com.us.theatre.repos.ActorRepository;
@Service
public class ActorImageServiceImpl implements ActorImageService{
 @Autowired
 ActorImageRepository imageRepository;
 
 
 
 @Autowired
 ActorService actorService;
 
 
 
 
 @Override
 public ActorImage uplaodImage(MultipartFile file) throws IOException {
	 return 
			 imageRepository.save(ActorImage.builder()
			 .name(file.getOriginalFilename())
			 .type(file.getContentType())
			 .image(file.getBytes()).build());
 }
 @Override
 public ActorImage getImageDetails(Long id) throws IOException{
	 final Optional<ActorImage> dbImage = imageRepository.findById(id);
	 return 
			 ActorImage.builder()
			 .idImage(dbImage.get().getIdImage())
			 .name(dbImage.get().getName())
			 .type(dbImage.get().getType())
			 .image(dbImage.get().getImage()).build();
 }
 @Override
 public ResponseEntity<byte[]> getImage(Long id) throws IOException{
	 final Optional<ActorImage> dbImage = imageRepository. findById (id);
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

package com.us.theatre.restcontroller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.us.theatre.entities.play.PlayImage;
import com.us.theatre.service.play.PlayImageService;

@RestController
@RequestMapping("/api/playimage")
@CrossOrigin(origins = "*")
public class PlayImageRestController {
	 @Autowired
	 PlayImageService imageService;
	 
	 @PostMapping("/upload")
	 public PlayImage uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		 return imageService.uplaodImage(file);
	 }
	 @GetMapping("/get/info/{id}")
	 public PlayImage getImageDetails(@PathVariable("id") Long id) throws IOException {
		 return imageService.getImageDetails(id) ;
	 }
	 @GetMapping("/load/{id}")
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		 return imageService.getImage(id);
	 }
	 @DeleteMapping("/delete/{id}")
	 public void deleteImage(@PathVariable("id") Long id){
		 imageService.deleteImage(id);
	 }
	 @PutMapping("/update")
	 public PlayImage UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
		 return imageService.uplaodImage(file);
	 }
}

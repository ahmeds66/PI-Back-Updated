package com.us.theatre.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.us.theatre.entities.actor.ActorImage;
import com.us.theatre.service.actor.ActorImageService;

import java.io.IOException;

@RestController
@RequestMapping("/api/actorimage")
@CrossOrigin(origins = "*")
public class ActorImageRestController {
 @Autowired
 ActorImageService imageService;
 
 @PostMapping("/upload")
 public ActorImage uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
 }
 @GetMapping("/get/info/{id}")
 public ActorImage getImageDetails(@PathVariable("id") Long id) throws IOException {
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
 public ActorImage UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
 }
}
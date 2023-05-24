package com.us.theatre.service.play;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.us.theatre.entities.play.PlayImage;

public interface PlayImageService {
	PlayImage uplaodImage(MultipartFile file) throws IOException;
	PlayImage getImageDetails(Long id) throws IOException;
	ResponseEntity<byte[]> getImage(Long id) throws IOException;
	void deleteImage(Long id);
}

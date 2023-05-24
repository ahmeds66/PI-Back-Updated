package com.us.theatre.service.actor;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.us.theatre.entities.actor.ActorImage;

public interface ActorImageService {
	ActorImage uplaodImage(MultipartFile file) throws IOException;
	ActorImage getImageDetails(Long id) throws IOException;
	ResponseEntity<byte[]> getImage(Long id) throws IOException;
	void deleteImage(Long id);
}

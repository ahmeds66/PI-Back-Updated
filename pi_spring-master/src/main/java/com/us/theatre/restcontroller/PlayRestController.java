package com.us.theatre.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.us.theatre.entities.play.Play;
import com.us.theatre.service.play.PlayService;
@RestController
@RequestMapping("/api/play")
@CrossOrigin
public class PlayRestController {
	@Autowired
	PlayService playService;
	
	@GetMapping("all")
	public List<Play> getAllActors() {
		return playService.getAllPlays();
	} 		
	
	@GetMapping("/getbyid/{id}")
	public Play getActorById(@PathVariable("id") Long id) {	
		return playService.getPlay(id);
    }
	
	@PostMapping("/addplay")
	public Play createActor(@RequestBody Play play) {
		System.out.println(play);
		return playService.savePlay(play);
	}

	@PutMapping("/updateplay")
	public Play updateActor(@RequestBody Play play) {
		return playService.updatePlay(play);
	}

	@DeleteMapping("/deleteplay/{id}")
	public void deleteActor(@PathVariable("id") Long id)
	{
		playService.deletePlayById(id);
	}
	
	@GetMapping("/titleplayscontains/{namePlay}")
	public List<Play> getPlaysByTitleContains(@PathVariable("namePlay") String namePlay) {
		return playService.findByTitlePlayContains(namePlay);
	 }
	
	@GetMapping("/playsbycat/{idCategory}")
	public List<Play> getPlaysByCatId(@PathVariable("idCategory") Long idCategory) {
		return playService.findByCategoryIdCat(idCategory);
	 }
}

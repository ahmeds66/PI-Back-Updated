package com.us.theatre.restcontroller;

import com.us.theatre.entities.actor.Actor;
import com.us.theatre.service.actor.ActorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actor")
@CrossOrigin
public class ActorRestController {
	@Autowired
	ActorService actorService;
	
	@GetMapping("all")
	public List<Actor> getAllActors() {
		return actorService.getAllActors();
	} 		
	
	@GetMapping("/getbyid/{id}")
	public Actor getActorById(@PathVariable("id") Long id) {	
		return actorService.getActor(id);
    }
	
	@PostMapping("/addactor")
	public Actor createActor(@RequestBody Actor actor) {
		System.out.println(actor);
		return actorService.saveActor(actor);
	}

	@PutMapping("/updateactor")
	public Actor updateActor(@RequestBody Actor actor) {
		return actorService.updateActor(actor);
	}

	@DeleteMapping("/deleteactor/{id}")
	public void deleteActor(@PathVariable("id") Long id)
	{
		actorService.deleteActorById(id);
	}
	
	@GetMapping("/nameactorscontains/{nameActor}")
	public List<Actor> getActorsByNameContains(@PathVariable("idCat") String nameActor) {
		return actorService.findByNameActorContains(nameActor);
	 }


}

package com.us.theatre.service.actor;

import java.util.List;

import com.us.theatre.entities.actor.Actor;

public interface ActorService {
	
	 Actor saveActor(Actor a);
	 Actor updateActor(Actor a);
	 void deleteActor(Actor a);
     void deleteActorById(Long id);
	 Actor getActor(Long id);
	 List<Actor> getAllActors();
	 
	 List<Actor> findByNameActor(String name);
	 List<Actor> findByNameActorContains(String name);
	 List<Actor> findByOrderByNameActorAsc();
	 List<Actor> trierActorsNames();

}
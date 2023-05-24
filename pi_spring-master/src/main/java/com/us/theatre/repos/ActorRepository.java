package com.us.theatre.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.us.theatre.entities.actor.Actor;
//@RepositoryRestResource(path = "restActor")
//@CrossOrigin
public interface ActorRepository extends JpaRepository<Actor, Long> {
	List<Actor> findByNameActor(String name);
	List<Actor> findByNameActorContains(String name);   
	
	@Query("select a from Actor a where a.nameActor like %:name")
	List<Actor> findByName (@Param("name") String name);	
	
	List<Actor> findByOrderByNameActorAsc();
	
	@Query("select a from Actor a order by a.nameActor ASC")
	List<Actor> trierActorsNames ();
	
}

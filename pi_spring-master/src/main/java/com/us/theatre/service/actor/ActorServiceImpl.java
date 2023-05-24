package com.us.theatre.service.actor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.theatre.entities.actor.Actor;
import com.us.theatre.repos.ActorImageRepository;
import com.us.theatre.repos.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	ActorImageRepository actorImageRepository;
	
	
	
	@Override
	public Actor saveActor(Actor a) {
		return actorRepository.save(a);
		
	}	
	@Override
	public Actor updateActor(Actor a) {
		//Long oldProdImageId = this.getProduit(p.getIdProduit()).getImage().getIdImage();
	//	Long newProdImageId = p.getImage().getIdImage();
		Actor actorUpdated = actorRepository.save(a);
		
	//	if (oldProdImageId != newProdImageId) // si l'image a été modifiée
		//	imageRepository.deleteById(oldProdImageId);
		return actorUpdated;
	}

	@Override
	public void deleteActor(Actor a) {
		actorRepository.delete(a);

	}

   @Override
	public void deleteActorById(Long id) {
	   
	   //supprimer l'image avant de supprimer le produit
	   Actor a = getActor(id);
	   try {
		Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+a.getImagePath()));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		actorRepository.deleteById(id);
		
	}

	@Override
	public Actor getActor(Long id) {
		return  actorRepository.findById(id).get();
	
	}

	@Override
	public List<Actor> getAllActors() {
		return actorRepository.findAll();
	}
	
    @Override
	public List<Actor> findByNameActor(String name) {
		return actorRepository.findByNameActor(name);
	}

	@Override
	public List<Actor> findByNameActorContains(String name) {
		return actorRepository.findByNameActorContains(name);
	}

	@Override
	public List<Actor> findByOrderByNameActorAsc() {
		return actorRepository.findByOrderByNameActorAsc();
	}

	@Override
	public List<Actor> trierActorsNames() {
		return actorRepository.trierActorsNames();
	}


}
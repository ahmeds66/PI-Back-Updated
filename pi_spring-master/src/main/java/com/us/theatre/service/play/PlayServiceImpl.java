package com.us.theatre.service.play;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.us.theatre.entities.category.Category;
import com.us.theatre.entities.play.Play;
import com.us.theatre.repos.PlayImageRepository;
import com.us.theatre.repos.PlayRepository;
@Service
public class PlayServiceImpl implements PlayService{
	
	@Autowired
	PlayRepository playRepository;
	
	@Autowired
	PlayImageRepository playImageRepository;
	
	
	
	@Override
	public Play savePlay(Play a) {
		return playRepository.save(a);
		
	}	
	@Override
	public Play updatePlay(Play a) {
		//Long oldProdImageId = this.getProduit(p.getIdProduit()).getImage().getIdImage();
	//	Long newProdImageId = p.getImage().getIdImage();
		Play playUpdated = playRepository.save(a);
		
	//	if (oldProdImageId != newProdImageId) // si l'image a été modifiée
		//	imageRepository.deleteById(oldProdImageId);
		return playUpdated;
	}

	@Override
	public void deletePlay(Play a) {
		playRepository.delete(a);

	}

   @Override
	public void deletePlayById(Long id) {
	   
	   //supprimer l'image avant de supprimer le produit
	   Play a = getPlay(id);
	   try {
		Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+a.getImagePath()));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		playRepository.deleteById(id);
		
	}

	@Override
	public Play getPlay(Long id) {
		return  playRepository.findById(id).get();
	
	}

	@Override
	public List<Play> getAllPlays() {
		return playRepository.findAll();
	}
	
    @Override
	public List<Play> findByTitlePlay(String name) {
		return playRepository.findByTitlePlay(name);
	}

	@Override
	public List<Play> findByTitlePlayContains(String name) {
		return playRepository.findByTitlePlayContains(name);
	}

	@Override
	public List<Play> findByOrderByTitlePlayAsc() {
		return playRepository.findByOrderByTitlePlayAsc();
	}

	@Override
	public List<Play> trierPlaysTitles() {
		return playRepository.trierPlaysTitles();
	}
	@Override
	public List<Play> findByCategory(Category category) {
		return playRepository.findByCategory(category);
	}
	@Override
	public List<Play> findByCategoryIdCat(Long id) {
		return playRepository.findByCategoryIdCategory(id);
	}
}

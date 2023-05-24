package com.us.theatre.service.play;

import java.util.List;

import com.us.theatre.entities.category.Category;
import com.us.theatre.entities.play.Play;

public interface PlayService {
	 Play savePlay(Play a);
	 Play updatePlay(Play a);
	 void deletePlay(Play a);
    void deletePlayById(Long id);
    Play getPlay(Long id);
	 List<Play> getAllPlays();
	 
	 List<Play> findByTitlePlay(String name);
	 List<Play> findByTitlePlayContains(String name);
	 List<Play> findByOrderByTitlePlayAsc();
	 List<Play> trierPlaysTitles();
	 
	 List<Play> findByCategory (Category category);
	 List<Play> findByCategoryIdCat(Long id);
}

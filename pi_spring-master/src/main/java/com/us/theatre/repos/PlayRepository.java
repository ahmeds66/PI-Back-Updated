package com.us.theatre.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.us.theatre.entities.category.Category;
import com.us.theatre.entities.play.Play;
//@RepositoryRestResource(path = "restPlay")
//@CrossOrigin
public interface PlayRepository extends JpaRepository<Play, Long> {
	List<Play> findByTitlePlay(String name);
	List<Play> findByTitlePlayContains(String name);   
	
	@Query("select a from Play a where a.titlePlay like %:name")
	List<Play> findByTitle (@Param("name") String name);	
	
	List<Play> findByOrderByTitlePlayAsc();
	
	@Query("select a from Play a order by a.titlePlay ASC")
	List<Play> trierPlaysTitles ();
	
	@Query("select p from Play p where p.category = ?1")
	List<Play> findByCategory (Category category);
	
	List<Play> findByCategoryIdCategory(Long id);
}

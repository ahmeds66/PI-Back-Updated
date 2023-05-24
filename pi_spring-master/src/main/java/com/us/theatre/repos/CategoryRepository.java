package com.us.theatre.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.us.theatre.entities.category.Category;
@RepositoryRestResource(path = "restCategory")
@CrossOrigin("*")
public interface CategoryRepository extends JpaRepository<Category, Long> {

}

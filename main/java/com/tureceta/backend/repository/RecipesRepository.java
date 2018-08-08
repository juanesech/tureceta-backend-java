package com.tureceta.backend.repository;

import com.tureceta.backend.model.RecipeModel;
import org.springframework.data.repository.CrudRepository;


public interface RecipesRepository extends CrudRepository<RecipeModel, String> {
    RecipeModel findOne(String id);

    @Override
    void delete(RecipeModel deleted);

}

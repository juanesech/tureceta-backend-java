package com.tureceta.backend.controller;

import com.tureceta.backend.model.RecipeModel;
import com.tureceta.backend.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewRecipeController {

    @Autowired
    RecipesRepository recipesRepository;

    @RequestMapping(method=RequestMethod.GET, value="/recipes")
    public Iterable<RecipeModel> recipe() {
        return recipesRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/recipes")
    public String save(@RequestBody RecipeModel recipe) {
        recipesRepository.save(recipe);

        return recipe.getId();
    }

    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public RecipeModel show(@PathVariable String id) {
        return recipesRepository.findOne(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/recipes/{id}")
    public RecipeModel update(@PathVariable String id, @RequestBody RecipeModel recipe) {
        RecipeModel prod = recipesRepository.findOne(id);
        if(recipe.getName() != null)
            prod.setName(recipe.getName());
        if(recipe.getInstructions() != null)
            prod.setInstructions(recipe.getInstructions());
        return prod;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/recipes/{id}")
    public String delete(@PathVariable String id) {
        RecipeModel recipe = recipesRepository.findOne(id);
        recipesRepository.delete(recipe);

        return "Recipe deleted";
    }
}

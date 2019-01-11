package swengs.fooddb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swengs.fooddb.dto.RecipeDTO;
import swengs.fooddb.dto.UserDTO;
import swengs.fooddb.facade.RecipeFacade;

import javax.validation.Valid;

@RestController
public class RecipeController {

    @Autowired
    private RecipeFacade recipeFacade;

    @GetMapping("/dto/recipe/{id}")
    RecipeDTO getById(@PathVariable Long id) {
        return recipeFacade.getById(id);
    }

    @PostMapping("/dto/recipe")
    RecipeDTO create(@RequestBody @Valid RecipeDTO dto) {
        return recipeFacade.create(dto);
    }

    @PutMapping("/dto/recipe/{id}")
    RecipeDTO update(@RequestBody @Valid RecipeDTO dto, @PathVariable Long id) {
        return recipeFacade.update(id, dto);
    }
}
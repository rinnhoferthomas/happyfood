package swengs.fooddb.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Dictionary;

@RepositoryRestResource
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long>, JpaRepository<Recipe, Long>, CrudRepository<Recipe, Long> {
    Recipe findAllByComplexity(Enum<Complexity> complexity);

}

package swengs.fooddb.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource
public interface FoodImageRepository extends PagingAndSortingRepository<FoodImage, Long>, JpaRepository<FoodImage, Long>, CrudRepository<FoodImage, Long> {


}

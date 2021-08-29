package one.digitalinnovation.dio_junit5_api_beer_stock.repository;

import one.digitalinnovation.dio_junit5_api_beer_stock.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeerRepository extends JpaRepository<Beer, Long> {

    Optional<Beer> findByName(String name);
}

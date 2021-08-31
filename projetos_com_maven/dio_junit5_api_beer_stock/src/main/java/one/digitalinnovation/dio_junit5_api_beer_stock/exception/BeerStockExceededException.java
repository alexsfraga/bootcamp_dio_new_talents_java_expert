package one.digitalinnovation.dio_junit5_api_beer_stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeerStockExceededException extends Exception {

    public BeerStockExceededException(Long id, int maxStock , int quantityToIncrement) {
        super(String.format("Beers with ID: %s to increment informed exceeds the max stock capacity: %s to increment %s", id, maxStock, quantityToIncrement));
    }
}

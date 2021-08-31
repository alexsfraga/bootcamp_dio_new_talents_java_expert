package one.digitalinnovation.dio_junit5_api_beer_stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeerStockInsufficientException extends Exception {

    public BeerStockInsufficientException(Long id, int quantityBeerStock, int quantityToDecrement) {
        super(String.format("Beers with ID: %s to decrement informed there is insufficient stock capacity: %s to decrement %s" , id, quantityBeerStock, quantityToDecrement));
    }
}

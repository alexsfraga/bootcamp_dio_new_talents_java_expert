package one.digitalinnovation.dio_junit5_api_beer_stock.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.dio_junit5_api_beer_stock.dto.BeerDTO;
import one.digitalinnovation.dio_junit5_api_beer_stock.dto.QuantityDTO;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.BeerAlreadyRegisteredException;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.BeerNotFoundException;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.BeerStockExceededException;
import one.digitalinnovation.dio_junit5_api_beer_stock.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerController implements BeerControllerDocs {

    private final BeerService beerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDTO createBeer(@RequestBody @Valid BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        return beerService.createBeer(beerDTO);
    }

    @GetMapping("/{name}")
    public BeerDTO findByName(@PathVariable String name) throws BeerNotFoundException {
        return beerService.findByName(name);
    }

    @GetMapping
    public List<BeerDTO> listBeers() {
        return beerService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BeerNotFoundException {
        beerService.deleteById(id);
    }

    @PatchMapping("/{id}/increment")
    public BeerDTO increment(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws BeerNotFoundException, BeerStockExceededException {
        return beerService.increment(id, quantityDTO.getQuantity());
    }

    /*@PutMapping(value="/{id}")
    public BeerDTO updateById(@PathVariable Long id, @RequestBody @Valid BeerDTO beerDTO) throws BeerNotFoundException {
        return beerService.updateById(id, beerDTO);
    }*/
}

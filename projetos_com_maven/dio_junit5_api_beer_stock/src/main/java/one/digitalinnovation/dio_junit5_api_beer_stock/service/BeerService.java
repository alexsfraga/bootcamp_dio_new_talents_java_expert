package one.digitalinnovation.dio_junit5_api_beer_stock.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.dio_junit5_api_beer_stock.dto.BeerDTO;
import one.digitalinnovation.dio_junit5_api_beer_stock.entity.Beer;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.BeerAlreadyRegisteredException;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.BeerStockInsufficientException;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.BeerNotFoundException;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.BeerStockExceededException;
import one.digitalinnovation.dio_junit5_api_beer_stock.mapper.BeerMapper;
import one.digitalinnovation.dio_junit5_api_beer_stock.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper = BeerMapper.INSTANCE;

    public BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(beerDTO.getName());
        Beer beer = beerMapper.toModel(beerDTO);
        Beer savedBeer = beerRepository.save(beer);
        return beerMapper.toDTO(savedBeer);
    }

    public BeerDTO findByName(String name) throws BeerNotFoundException { //throws ObjectNotFoundException {

        Beer foundBeer = beerRepository.findByName(name)
                .orElseThrow(() -> new BeerNotFoundException(name));
        return beerMapper.toDTO(foundBeer);
    }

    public List<BeerDTO> listAll() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws BeerNotFoundException {
        verifyIfExists(id);
        beerRepository.deleteById(id);
    }

    private void verifyIfIsAlreadyRegistered(String name) throws BeerAlreadyRegisteredException {
        Optional<Beer> optSavedBeer = beerRepository.findByName(name);
        if (optSavedBeer.isPresent()) {
            throw new BeerAlreadyRegisteredException(name);
        }
    }

    private Beer verifyIfExists(Long id) throws BeerNotFoundException { //throws ObjectNotFoundException {
        return beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException(id));
    }

    public BeerDTO increment(Long id, int quantityToIncrement) throws BeerNotFoundException, BeerStockExceededException {
        Beer beerToIncrementStock = verifyIfExists(id);
        int quantityAfterIncrement = quantityToIncrement + beerToIncrementStock.getQuantity();
        if (quantityAfterIncrement <= beerToIncrementStock.getMax()) {
            beerToIncrementStock.setQuantity(beerToIncrementStock.getQuantity() + quantityToIncrement);
            Beer incrementedBeerStock = beerRepository.save(beerToIncrementStock);
            return beerMapper.toDTO(incrementedBeerStock);
        }
        throw new BeerStockExceededException(id, beerToIncrementStock.getMax() ,quantityToIncrement);
    }

    public BeerDTO decrement(Long id, int quantityToDecrement) throws BeerNotFoundException, BeerStockInsufficientException {
        Beer beerToDecrementStock = verifyIfExists(id);
        int quantityAfterDecrement = beerToDecrementStock.getQuantity() - quantityToDecrement;
        if ( quantityAfterDecrement >= 0 ) {
            beerToDecrementStock.setQuantity(beerToDecrementStock.getQuantity() - quantityToDecrement );
            Beer DecrementedBeerStock = beerRepository.save(beerToDecrementStock);
            return beerMapper.toDTO(DecrementedBeerStock);
        }
        throw new BeerStockInsufficientException( id, beerToDecrementStock.getQuantity(), quantityToDecrement);
    }

}

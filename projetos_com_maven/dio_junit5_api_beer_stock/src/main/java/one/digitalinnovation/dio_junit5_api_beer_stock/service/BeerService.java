package one.digitalinnovation.dio_junit5_api_beer_stock.service;

import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import one.digitalinnovation.dio_junit5_api_beer_stock.dto.BeerDTO;
import one.digitalinnovation.dio_junit5_api_beer_stock.entity.Beer;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.BeerAlreadyRegisteredException;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.BeerNotFoundException;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.BeerStockExceededException;
import one.digitalinnovation.dio_junit5_api_beer_stock.exception.message.ObjectNotFoundException;
import one.digitalinnovation.dio_junit5_api_beer_stock.mapper.BeerMapper;
import one.digitalinnovation.dio_junit5_api_beer_stock.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.CacheOperationInvoker;
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
                //.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado com o nome: " + name ));
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
                //.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado com o ID: " + id));
    }

    public BeerDTO increment(Long id, int quantityToIncrement) throws BeerNotFoundException, BeerStockExceededException {
        Beer beerToIncrementStock = verifyIfExists(id);
        int quantityAfterIncrement = quantityToIncrement + beerToIncrementStock.getQuantity();
        if (quantityAfterIncrement <= beerToIncrementStock.getMax()) {
            beerToIncrementStock.setQuantity(beerToIncrementStock.getQuantity() + quantityToIncrement);
            Beer incrementedBeerStock = beerRepository.save(beerToIncrementStock);
            return beerMapper.toDTO(incrementedBeerStock);
        }
        throw new BeerStockExceededException(id, quantityToIncrement);
    }

    /*public BeerDTO updateById(Long id, BeerDTO personDTO) throws BeerNotFoundException {
        verifyIfExists(id);
        Beer beerToSave = beerMapper.toModel(personDTO);
        Beer savedBeer = beerRepository.save(beerToSave);

        return beerMapper.toDTO(savedBeer);
    }*/
}

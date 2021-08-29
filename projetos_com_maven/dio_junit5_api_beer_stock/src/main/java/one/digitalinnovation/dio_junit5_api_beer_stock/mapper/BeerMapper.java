package one.digitalinnovation.dio_junit5_api_beer_stock.mapper;

import one.digitalinnovation.dio_junit5_api_beer_stock.dto.BeerDTO;
import one.digitalinnovation.dio_junit5_api_beer_stock.entity.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    Beer toModel(BeerDTO beerDTO);

    BeerDTO toDTO(Beer beer);
}

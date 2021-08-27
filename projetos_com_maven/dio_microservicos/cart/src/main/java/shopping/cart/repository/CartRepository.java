package shopping.cart.repository;

import org.springframework.data.repository.CrudRepository;
import shopping.cart.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}

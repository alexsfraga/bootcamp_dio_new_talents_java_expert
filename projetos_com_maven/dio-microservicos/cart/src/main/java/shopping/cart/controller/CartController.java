package shopping.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopping.cart.model.Cart;
import shopping.cart.repository.CartRepository;

import java.util.Optional;

@RestController
@RequestMapping(value="/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping( value = "/{id}",method = RequestMethod.GET)
    public Optional<Cart> select(@PathVariable Integer id){
        return cartRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Cart create(@RequestBody Cart cart){
        return cartRepository.save(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        cartRepository.deleteById(id);
    }
}

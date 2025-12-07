package com.masai.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Cart;
import com.masai.models.CartDTO;
import com.masai.models.CartItem;
import com.masai.repository.CartDao;
import com.masai.repository.CustomerDao;
import com.masai.service.CartService;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private CustomerDao customerDao;

    @Operation(summary = "Add product to cart", description = "Adds a product to the customer's cart using productId and quantity.")
    @PostMapping(value = "/cart/add")
    public ResponseEntity<Cart> addProductToCartHandler(@RequestBody CartDTO cartdto, @RequestHeader("token") String token) {
        Cart cart = cartService.addProductToCart(cartdto, token);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @Operation(summary = "View cart", description = "Fetches all items currently in the user's cart.")
    @GetMapping(value = "/cart")
    public ResponseEntity<Cart> getCartProductHandler(@RequestHeader("token") String token) {
        return new ResponseEntity<>(cartService.getCartProduct(token), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Remove product from cart", description = "Removes a specific product from the user's cart.")
    @DeleteMapping(value = "/cart")
    public ResponseEntity<Cart> removeProductFromCartHandler(@RequestBody CartDTO cartdto, @RequestHeader("token") String token) {
        Cart cart = cartService.removeProductFromCart(cartdto, token);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @Operation(summary = "Clear cart", description = "Removes all items from the user's cart.")
    @DeleteMapping(value = "/cart/clear")
    public ResponseEntity<Cart> clearCartHandler(@RequestHeader("token") String token) {
        return new ResponseEntity<>(cartService.clearCart(token), HttpStatus.ACCEPTED);
    }
}

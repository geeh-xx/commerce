package br.unibh.tcc.commerce.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unibh.tcc.commerce.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}

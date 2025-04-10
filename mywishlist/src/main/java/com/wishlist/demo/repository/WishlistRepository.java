package com.wishlist.demo.repository;

import com.wishlist.demo.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    @EntityGraph(attributePaths = "books")
    List<Wishlist> findByUserId(Long userId);
}
package com.github.knextsunj.homebank.colorcardmaster.repository;

import com.github.knextsunj.homebank.colorcardmaster.domain.ColorCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorCardRepository extends JpaRepository<ColorCard, Long> {
    @Query
    List<ColorCard> findAllColorCardOrderByName();
}

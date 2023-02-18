package com.github.knextsunj.homebank.cardtypemaster.repository;

import com.github.knextsunj.homebank.cardtypemaster.domain.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Long> {
    @Query
    List<CardType> findAllCardTypeOrderByName();
}

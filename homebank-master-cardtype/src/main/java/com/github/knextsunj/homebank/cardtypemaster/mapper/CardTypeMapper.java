package com.github.knextsunj.homebank.cardtypemaster.mapper;

import com.github.knextsunj.homebank.cardtypemaster.domain.CardType;
import com.github.knextsunj.homebank.cardtypemaster.dto.CardTypeDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardTypeMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "deleted", source = "deleted")
    CardType fromColorCardDTO(CardTypeDTO cardTypeDTO);

    @InheritInverseConfiguration
    CardTypeDTO toColorCardDTO(CardType cardType);
}

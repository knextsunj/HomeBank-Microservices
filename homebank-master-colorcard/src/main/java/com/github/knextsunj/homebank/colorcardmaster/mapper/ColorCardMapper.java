package com.github.knextsunj.homebank.colorcardmaster.mapper;

import com.github.knextsunj.homebank.colorcardmaster.dto.ColorCardDTO;
import com.github.knextsunj.homebank.colorcardmaster.domain.ColorCard;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ColorCardMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "deleted", source = "deleted")
    ColorCard fromColorCardDTO(ColorCardDTO colorCardDTO);

    @InheritInverseConfiguration
    ColorCardDTO toColorCardDTO(ColorCard colorCard);
}

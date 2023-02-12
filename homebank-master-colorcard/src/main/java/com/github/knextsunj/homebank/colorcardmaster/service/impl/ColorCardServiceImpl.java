package com.github.knextsunj.homebank.colorcardmaster.service.impl;

import com.github.knextsunj.homebank.colorcardmaster.domain.ColorCard;
import com.github.knextsunj.homebank.colorcardmaster.dto.ColorCardDTO;
import com.github.knextsunj.homebank.colorcardmaster.mapper.ColorCardMapper;
import com.github.knextsunj.homebank.colorcardmaster.repository.ColorCardRepository;
import com.github.knextsunj.homebank.colorcardmaster.service.ColorCardService;
import com.github.knextsunj.homebank.colorcardmaster.util.ColorCardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class ColorCardServiceImpl implements ColorCardService {

    @Autowired
    private ColorCardRepository colorCardRepository;

    @Autowired
    private ColorCardMapper colorCardMapper;

    @Override
    public boolean saveColorCard(ColorCardDTO colorCardDTO) {

        if (Optional.ofNullable(colorCardDTO).isPresent() && !ColorCardUtil.isNull(colorCardDTO.name())) {
            ColorCard colorCard = colorCardMapper.fromColorCardDTO(colorCardDTO);
            ColorCard result = colorCardRepository.save(colorCard);
            return null != result ? true : false;
        }
        return false;
    }

    @Override
    public boolean updateColorCard(ColorCardDTO colorCardDTO) {
        ColorCard result = null;

        if (Optional.ofNullable(colorCardDTO).isPresent() && ColorCardUtil.isNumPresent(colorCardDTO.id())) {
            Optional<ColorCard> colorCardOptional = colorCardRepository.findById(colorCardDTO.id());
            if (colorCardOptional.isPresent()) {
                ColorCard colorCard = colorCardOptional.get();
                colorCard.setName(colorCardDTO.name());
                if (!ColorCardUtil.isNull(colorCardDTO.deleted())) {
                    colorCard.setDeleted(colorCardDTO.deleted());
                }
                result = colorCardRepository.save(colorCard);
            }
            return result != null ? true : false;
        }

        return false;
    }

    @Override
    public ColorCardDTO fetchColorCardById(long id) {
        Optional<ColorCard> colorCardOptional = colorCardRepository.findById(id);
        if (colorCardOptional.isPresent()) {
            return colorCardMapper.toColorCardDTO(colorCardOptional.get());
        }
        return null;
    }

    @Override
    public List<ColorCardDTO> fetchAllColorCard() {
        Function<ColorCard, ColorCardDTO> function = colorCard -> colorCardMapper.toColorCardDTO(colorCard);
        return colorCardRepository.findAllColorCardOrderByName().stream().map(function).collect(Collectors.toList());
    }
}

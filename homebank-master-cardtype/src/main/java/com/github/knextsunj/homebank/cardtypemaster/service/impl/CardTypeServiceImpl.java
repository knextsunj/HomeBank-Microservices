package com.github.knextsunj.homebank.cardtypemaster.service.impl;

import com.github.knextsunj.homebank.cardtypemaster.domain.CardType;
import com.github.knextsunj.homebank.cardtypemaster.dto.CardTypeDTO;
import com.github.knextsunj.homebank.cardtypemaster.exception.ValidationFailureException;
import com.github.knextsunj.homebank.cardtypemaster.exception.ValidationServiceInvocationException;
import com.github.knextsunj.homebank.cardtypemaster.mapper.CardTypeMapper;
import com.github.knextsunj.homebank.cardtypemaster.repository.CardTypeRepository;
import com.github.knextsunj.homebank.cardtypemaster.restclient.BusinessRuleEngineClient;
import com.github.knextsunj.homebank.cardtypemaster.util.CardTypeUtil;
import com.github.knextsunj.homebank.cardtypemaster.service.CardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class CardTypeServiceImpl implements CardTypeService {

    @Autowired
    private CardTypeRepository cardTypeRepository;

    @Autowired
    private CardTypeMapper cardTypeMapper;

    @Autowired
    private BusinessRuleEngineClient businessRuleEngineClient;

    @Override
    public boolean saveCardType(CardTypeDTO cardTypeDTO) {

        if (Optional.ofNullable(cardTypeDTO).isPresent() && !CardTypeUtil.isNull(cardTypeDTO.name())) {
            try {
                if (businessRuleEngineClient.executeDeDup(cardTypeDTO.name())) {
                    CardType cardType = cardTypeMapper.fromColorCardDTO(cardTypeDTO);
                    CardType result = cardTypeRepository.save(cardType);
                    return null != result ? true : false;
                }
            } catch (ValidationServiceInvocationException ex) {
                throw new ValidationFailureException((ex.getMessage()));
            }
        }
        return false;
    }

    @Override
    public boolean updateCardType(CardTypeDTO cardTypeDTO) {
        CardType result = null;

        if (Optional.ofNullable(cardTypeDTO).isPresent() && CardTypeUtil.isNumPresent(cardTypeDTO.id())) {
            try {
                    Optional<CardType> colorCardOptional = cardTypeRepository.findById(cardTypeDTO.id());
                    if (colorCardOptional.isPresent()) {
                        CardType cardType = colorCardOptional.get();
                        cardType.setName(cardTypeDTO.name());
                        if (!CardTypeUtil.isNull(cardTypeDTO.deleted())) {
                            cardType.setDeleted(cardTypeDTO.deleted());
                        }
                        result = cardTypeRepository.save(cardType);
                    }
                return result != null ? true : false;
            } catch (ValidationServiceInvocationException ex) {
                throw new ValidationFailureException((ex.getMessage()));
            }
        }

        return false;
    }

    @Override
    public CardTypeDTO fetchCardTypeById(long id) {
        Optional<CardType> colorCardOptional = cardTypeRepository.findById(id);
        if (colorCardOptional.isPresent()) {
            return cardTypeMapper.toColorCardDTO(colorCardOptional.get());
        }
        return null;
    }

    @Override
    public List<CardTypeDTO> fetchAllCardType() {
        Function<CardType, CardTypeDTO> function = cardType -> cardTypeMapper.toColorCardDTO(cardType);
        return cardTypeRepository.findAllCardTypeOrderByName().stream().map(function).collect(Collectors.toList());
    }
}

package com.resellerapp.service.impl;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ConditionRepository conditionRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ConditionRepository conditionRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void addOffer(OfferServiceModel offerServiceModel) {

        ConditionEntity condition = conditionRepository.findByConditionName(offerServiceModel.getConditionName());

        if (condition != null) {
            offerRepository.save(modelMapper.map(
                    offerServiceModel, OfferEntity.class));
        }
    }
}

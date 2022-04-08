package com.divyansh.xharktank.service.impl;

import com.divyansh.xharktank.entity.Offer;
import com.divyansh.xharktank.entity.Pitch;
import com.divyansh.xharktank.repository.OfferRepository;
import com.divyansh.xharktank.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Optional<Long> saveOffer(Offer offer, Pitch pitch) {
        offer.setPitch(pitch);
        offer = offerRepository.save(offer);
        if(offer.getOfferId() != null) return Optional.of(offer.getOfferId());
        return Optional.empty();

    }
}

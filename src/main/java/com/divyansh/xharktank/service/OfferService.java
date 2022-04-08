package com.divyansh.xharktank.service;

import com.divyansh.xharktank.entity.Offer;
import com.divyansh.xharktank.entity.Pitch;

import java.util.Optional;


public interface OfferService {

    Optional<Long> saveOffer(Offer offer, Pitch pitch);

}

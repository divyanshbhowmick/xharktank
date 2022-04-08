package com.divyansh.xharktank.controller;

import com.divyansh.xharktank.dto.SaveEntityDTO;
import com.divyansh.xharktank.entity.Offer;
import com.divyansh.xharktank.entity.Pitch;
import com.divyansh.xharktank.service.OfferService;
import com.divyansh.xharktank.service.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pitches")
public class PitchController {

    @Autowired
    private PitchService pitchService;

    @Autowired
    private OfferService offerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pitch>> getAllPitches() {
        Optional<List<Pitch>> pitches = pitchService.getAllPitches();
        return pitches.map(pitchList -> new ResponseEntity<>(pitchList, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> savePitch(@Valid @RequestBody Pitch pitch) {
        Optional<Long> pitchId = pitchService.savePitch(pitch);
        return pitchId.<ResponseEntity<Object>>map(id -> ResponseEntity.status(201).body(new SaveEntityDTO(id))).orElseGet(() -> ResponseEntity.status(400).build());
    }

    @GetMapping("/{pitchId}")
    public ResponseEntity<Pitch> getPitch(@PathVariable Long pitchId) {
        Optional<Pitch> pitch = pitchService.getPitchById(pitchId);
        return pitch.map(pitchList -> new ResponseEntity<>(pitchList, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/{pitchId}/makeOffer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> makeOffer(@PathVariable Long pitchId, @Valid @RequestBody Offer offer) {
        Optional<Pitch> pitch = pitchService.getPitchById(pitchId);
        if (pitch.isPresent()) {
            Optional<Long> offerId = offerService.saveOffer(offer, pitch.get());
            return offerId.<ResponseEntity<Object>>map(id -> ResponseEntity.status(201).body(new SaveEntityDTO(id))).orElseGet(() -> ResponseEntity.status(400).build());
        }
        return ResponseEntity.status(404).build();

    }
}

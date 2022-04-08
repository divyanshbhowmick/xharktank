package com.divyansh.xharktank.service.impl;

import com.divyansh.xharktank.entity.Pitch;
import com.divyansh.xharktank.repository.PitchRepository;
import com.divyansh.xharktank.service.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PitchServiceImpl implements PitchService {

    @Autowired
    private PitchRepository pitchRepository;


    @Override
    public Optional<List<Pitch>> getAllPitches() {
        return pitchRepository.fetchAllPitches();
    }

    @Override
    public Optional<Long> savePitch(Pitch pitch) {
        pitchRepository.save(pitch);
        if(pitch.getPitchId() != null) return Optional.of(pitch.getPitchId());
        return Optional.empty();
    }

    @Override
    public Optional<Pitch> getPitchById(Long pitchId){
        return pitchRepository.findById(pitchId);
    }
}

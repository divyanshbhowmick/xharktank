package com.divyansh.xharktank.service;

import com.divyansh.xharktank.entity.Pitch;

import java.util.List;
import java.util.Optional;

public interface PitchService {

    Optional<List<Pitch>> getAllPitches();

    Optional<Long> savePitch(Pitch pitch);

    Optional<Pitch> getPitchById(Long pitchId);
}

package com.divyansh.xharktank.repository;

import com.divyansh.xharktank.entity.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PitchRepository extends JpaRepository<Pitch, Long> {

    @Query(value = "SELECT p FROM Pitch p LEFT JOIN FETCH p.offers ORDER BY p.pitchId DESC")
    Optional<List<Pitch>> fetchAllPitches();

    @Query(value = "SELECT p FROM Pitch p LEFT JOIN FETCH p.offers WHERE p.pitchId = ?1")
    Optional<Pitch> findById(Long pitchId);
}

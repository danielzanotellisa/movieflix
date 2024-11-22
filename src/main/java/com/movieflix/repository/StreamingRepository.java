package com.movieflix.repository;

import com.movieflix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming,Long> {
}

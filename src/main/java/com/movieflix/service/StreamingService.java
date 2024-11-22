package com.movieflix.service;

import com.movieflix.entity.Streaming;
import com.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public List<Streaming> findAll() {
        return streamingRepository.findAll();
    }

    public Streaming createStreaming(Streaming body) {
        return streamingRepository.save(body);
    }

    public Optional<Streaming> findStreamingById(Long id) {
        return streamingRepository.findById(id);
    }

    public void deleteStreamingById(Long id) {
        streamingRepository.deleteById(id);
    }
}

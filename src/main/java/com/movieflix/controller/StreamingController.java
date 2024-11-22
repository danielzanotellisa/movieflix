package com.movieflix.controller;

import com.movieflix.controller.mapper.StreamingMapper;
import com.movieflix.controller.request.StreamingRequest;
import com.movieflix.controller.response.StreamingResponse;
import com.movieflix.entity.Streaming;
import com.movieflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService service;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList());
    }

    @PostMapping("/save")
    public ResponseEntity<StreamingResponse> createStreaming(@RequestBody StreamingRequest request) {
        Streaming streaming = StreamingMapper.toStreaming(request);
        Streaming saved = service.createStreaming(streaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findStreamingById(@PathVariable Long id) {

        return service.findStreamingById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreamingById (@PathVariable Long id) {
        service.deleteStreamingById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

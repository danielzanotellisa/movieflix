package com.movieflix.controller.response;

import com.movieflix.entity.Streaming;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(Long id,
                            String title,
                            String description,
                            LocalDate releaseDate,
                            Double rating,
                            List<CategoryResponse> categories,
                            List<StreamingResponse> streamings) {
}

package com.movieflix.controller.request;


import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRequest (String title,
                            String description,
                            LocalDate releaseDate,
                            Double rating,
                            List<Long> categories,
                            List<Long> streamings) {
}

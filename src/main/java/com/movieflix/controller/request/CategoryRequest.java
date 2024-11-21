package com.movieflix.controller.request;

import lombok.Builder;

@Builder
public record CategoryRequest(String name) {
}

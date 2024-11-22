package com.movieflix.controller.mapper;

import com.movieflix.controller.request.CategoryRequest;
import com.movieflix.controller.response.CategoryResponse;
import com.movieflix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.name())
                .id(categoryRequest.id())
                .build();


    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .name(category.getName())
                .build();
    }
}

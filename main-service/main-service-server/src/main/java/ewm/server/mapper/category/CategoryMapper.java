package ewm.server.mapper.category;

import ewm.server.dto.category.CategoryDto;
import ewm.server.model.category.Category;

public class CategoryMapper {
    public static CategoryDto mapModelToDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
package ewm.server.controller.category;

import ewm.server.dto.category.CategoryDto;
import ewm.server.dto.category.NewCategoryDto;
import ewm.server.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {
    private static final String CAT_ADMIN_GENERAL_PATH = "/admin/categories";
    private static final String CAT_ADMIN_BY_ID_PATH = CAT_ADMIN_GENERAL_PATH + "/{catId}";
    private static final String CAT_PUBLIC_PATH = "/categories";
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = CAT_ADMIN_GENERAL_PATH)
    public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody NewCategoryDto category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(category));
    }

    @PatchMapping(value = CAT_ADMIN_BY_ID_PATH)
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("catId") Long catId, @Valid @RequestBody CategoryDto category) {
        return ResponseEntity.ok().body(categoryService.updateCategory(catId, category));
    }

    @DeleteMapping(value = CAT_ADMIN_BY_ID_PATH)
    public ResponseEntity<Void> deleteCategory(@PathVariable("catId") Long catId) {
        categoryService.deleteCategory(catId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(CAT_PUBLIC_PATH)
    public ResponseEntity<List<CategoryDto>> getAllCategories(@RequestParam(required = false, defaultValue = "0") int from,
                                                              @RequestParam(required = false, defaultValue = "10") int size) {
        return ResponseEntity.ok().body(categoryService.getAllCategories(from, size));
    }

    @GetMapping(CAT_PUBLIC_PATH + "/{catId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("catId") Long catId) {
        return ResponseEntity.ok().body(categoryService.getCategoryById(catId));
    }
}

package by.kapitonov.computer.shop.backend.rest.controller.product.details;

import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.service.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-categories")
public class ProductCategoryRestController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryRestController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllProductCategories() {
        List<String> productCategoryNames = productCategoryService.getAllCategoryNames();

        return new ResponseEntity(productCategoryNames, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createCategory(@RequestBody String categoryName) {

        productCategoryService.create(categoryName);

        return new ResponseEntity<>(new ApiResponse("Product category successfully created"), HttpStatus.OK);
    }
}

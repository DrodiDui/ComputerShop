package by.kapitonov.computer.shop.backend.rest.controller;

import by.kapitonov.computer.shop.backend.model.Product;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable(name = "category") String category, Pageable pageable) {
        Page<Product> products = productService.getAllByCategory(category, pageable);

        return new ResponseEntity<>(products.getContent(), HttpStatus.OK);
    }

    @GetMapping("/{category}/{name}")
    public ResponseEntity<Product> getProductByName(
            @PathVariable(name = "category") String category,
            @PathVariable(name = "name") String productName) {

        Product product = productService.getOneByNameAndCategory(category, productName);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDTO productDTO) {

        productService.create(productDTO);

        return new ResponseEntity<>(new ApiResponse("Product successfully created"), HttpStatus.OK);
    }


}

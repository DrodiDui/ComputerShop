package by.kapitonov.computer.shop.backend.rest.controller.product;

import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.rest.mapper.ProductMapper;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.rest.vm.ProductVM;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Api
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{category}/{name}")
    public ResponseEntity<Product> getProductByName(
            @PathVariable(name = "category") String category,
            @PathVariable(name = "name") String productName) {

        Product product = productService.getOneByNameAndCategory(category, productName);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/{product-name}")
    public ResponseEntity<List<Product>> getAllProductsByName(@PathVariable(name = "product-name") String productName) {

        List<Product> products = productService.getAllProductByName(productName);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDTO productDTO) {

        productService.create(productDTO);

        return new ResponseEntity<>(new ApiResponse("Product successfully created"), HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<List<ProductVM>> getAllProductsByIds(@RequestBody List<Long> ids) {

        List<Product> products = productService.getAllProductsByIds(ids);
        List<ProductVM> productVMS = ProductMapper.toVMList(products);

        return new ResponseEntity<>(productVMS, HttpStatus.OK);
    }

}

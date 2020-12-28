package by.kapitonov.computer.shop.backend.rest.controller.product.details;

import by.kapitonov.computer.shop.backend.service.ProductStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product-statuses")
public class ProductStatusRestController {

    private final ProductStatusService productStatusService;

    public ProductStatusRestController(ProductStatusService productStatusService) {
        this.productStatusService = productStatusService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllProductStatusNames() {

        List<String> productStatusNames = productStatusService.getAllProductStatsNames();

        return new ResponseEntity<>(productStatusNames, HttpStatus.OK);
    }
}

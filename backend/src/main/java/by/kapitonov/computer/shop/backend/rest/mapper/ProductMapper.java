package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.rest.vm.ProductVM;
import by.kapitonov.computer.shop.backend.util.ImageUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductMapper {

    public static List<ProductVM> toVMList(List<Product> products) {
        return products
                .stream()
                .filter(Objects::nonNull)
                .map(ProductMapper::toVM)
                .collect(Collectors.toList());
    }

    public static ProductVM toVM(Product product) {
        return ProductVM.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .model(product.getModel())
                .brand(product.getBrand())
                .ageOfRelease(product.getAgeOfRelease())
                .countInStock(product.getCountInStock())
                .productCategory(product.getProductCategory().getCategoryName())
                .productStatus(product.getProductStatus().getStatusName())
                .previewImage(ImageUtils.getImage(product.getPreviewImage()))
                .build();
    }

}

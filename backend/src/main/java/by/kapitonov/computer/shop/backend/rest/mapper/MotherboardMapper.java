package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.Motherboard;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.rest.vm.MotherboardVM;
import by.kapitonov.computer.shop.backend.rest.vm.ProductVM;
import by.kapitonov.computer.shop.backend.util.ImageUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MotherboardMapper {

    public static List<MotherboardVM> motherboardsToMotherboardsVM(List<Motherboard> motherboards) {
        return motherboards.stream()
                .filter(Objects::nonNull)
                .map(MotherboardMapper::motherboardToMotherboardVM)
                .collect(Collectors.toList());
    }

    public static MotherboardVM motherboardToMotherboardVM(Motherboard motherboard) {
        if (motherboard == null) {
            throw new ProductNotFoundException("Motherboard cannot been mapped to MotherboardVm entity");
        }

        return MotherboardVM.builder()
                .numberOfMemorySlot(motherboard.getNumberOfMemorySlot())
                .maximumMemorySize(motherboard.getMaximumMemorySize())
                .maximumMemoryFrequency(motherboard.getMaximumMemoryFrequency())
                .socket(motherboard.getSocket().getSocketName())
                .formFactor(motherboard.getFormFactor().getFormFactorName())
                .typeOfMemory(motherboard.getTypeOfMemory().getTypeName())
                .product(getProductVM(motherboard.getProduct()))
                .build();
    }

    private static ProductVM getProductVM(Product product) {
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

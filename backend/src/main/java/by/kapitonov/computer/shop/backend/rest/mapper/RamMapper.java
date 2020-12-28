package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.Ram;
import by.kapitonov.computer.shop.backend.model.product.detail.RamMemoryType;
import by.kapitonov.computer.shop.backend.rest.vm.ProductVM;
import by.kapitonov.computer.shop.backend.rest.vm.RamVM;

import java.util.List;
import java.util.stream.Collectors;

public class RamMapper {

    public static RamVM toVM(Ram ram) {
        if (ram == null) {
            return null;
        }

        return RamVM.builder()
                .size(ram.getSize())
                .frequency(ram.getFrequency())
                .backlight(ram.getBacklight())
                .cooling(ram.getCooling())
                .ramMemoryType(getMemoryType(ram.getRamMemoryType()))
                .product(getProductVM(ram.getProduct()))
                .build();
    }

    public static List<RamVM> toVMList(List<Ram> rams) {
        return rams
                .stream()
                .map(RamMapper::toVM)
                .collect(Collectors.toList());
    }

    private static ProductVM getProductVM(Product product) {
        if (product == null) {
            return null;
        }

        return ProductMapper.toVM(product);
    }

    private static String getMemoryType(RamMemoryType ramMemoryType) {
        if (ramMemoryType == null) {
            return null;
        }

        return ramMemoryType.getTypeName();
    }
}

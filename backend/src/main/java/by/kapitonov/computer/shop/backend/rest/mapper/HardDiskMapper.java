package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.model.product.HardDisk;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.rest.vm.HardDiskVM;
import by.kapitonov.computer.shop.backend.rest.vm.ProductVM;

import java.util.List;
import java.util.stream.Collectors;

public class HardDiskMapper {

    public static HardDiskVM toVM(HardDisk hardDisk) {
        if (hardDisk == null) {
            return null;
        }

        return HardDiskVM.builder()
                .diskSize(hardDisk.getDiskSize())
                .spindleSpeed(hardDisk.getSpindleSpeed())
                .product(getProductVM(hardDisk.getProduct()))
                .build();
    }

    public static List<HardDiskVM> toVMList(List<HardDisk> hardDisks) {
        return hardDisks
                .stream()
                .map(HardDiskMapper::toVM)
                .collect(Collectors.toList());
    }

    private static ProductVM getProductVM(Product product) {
        return ProductMapper.toVM(product);
    }
}

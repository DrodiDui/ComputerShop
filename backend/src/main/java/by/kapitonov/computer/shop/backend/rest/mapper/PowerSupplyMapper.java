package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.model.product.PowerSupply;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.detail.PowerSupplyCategory;
import by.kapitonov.computer.shop.backend.rest.vm.PowerSupplyVM;
import by.kapitonov.computer.shop.backend.rest.vm.ProductVM;

import java.util.List;
import java.util.stream.Collectors;

public class PowerSupplyMapper {

    public static PowerSupplyVM toVM(PowerSupply powerSupply) {
        if (powerSupply == null) {
            return null;
        }

        return PowerSupplyVM.builder()
                .power(powerSupply.getPower())
                .certificate(powerSupply.getCertificate())
                .modulePowerCableConnection(powerSupply.getModulePowerCableConnection())
                .width(powerSupply.getWidth())
                .height(powerSupply.getHeight())
                .depth(powerSupply.getDepth())
                .powerSupplyCategory(getPowerSupplyCategory(powerSupply.getPowerSupplyCategory()))
                .product(getProductVM(powerSupply.getProduct()))
                .build();
    }

    public static List<PowerSupplyVM> toVMList(List<PowerSupply> powerSupplies) {
        return powerSupplies
                .stream()
                .map(PowerSupplyMapper::toVM)
                .collect(Collectors.toList());
    }

    public static ProductVM getProductVM(Product product) {
        return ProductMapper.toVM(product);
    }

    private static String getPowerSupplyCategory(PowerSupplyCategory powerSupplyCategory) {
        if (powerSupplyCategory == null) {
            return null;
        }
        return powerSupplyCategory.getCategoryName();
    }

}

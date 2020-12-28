package by.kapitonov.computer.shop.backend.rest.mapper;

import by.kapitonov.computer.shop.backend.model.product.CoolingSystem;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.detail.Socket;
import by.kapitonov.computer.shop.backend.rest.vm.CoolingSystemVM;
import by.kapitonov.computer.shop.backend.rest.vm.ProductVM;

import java.util.List;
import java.util.stream.Collectors;

public class CoolingSystemMapper {

    public static CoolingSystemVM toVM(CoolingSystem coolingSystem) {
        if (coolingSystem == null) {
            return null;
        }
        return CoolingSystemVM.builder()
                .powerDissipation(coolingSystem.getPowerDissipation())
                .radiatorMaterial(coolingSystem.getRadiatorMaterial())
                .numberOfHeatPipes(coolingSystem.getNumberOfHeatPipes())
                .fanDiameter(coolingSystem.getFanDiameter())
                .countOfFan(coolingSystem.getCountOfFan())
                .maxRotationSpeed(coolingSystem.getMaxRotationSpeed())
                .backlight(coolingSystem.getBacklight())
                .socket(getSocket(coolingSystem.getSocket()))
                .product(getProduct(coolingSystem.getProduct()))
                .build();
    }

    private static String getSocket(Socket socket) {
        if (socket == null) {
            return null;
        }
        return socket.getSocketName();
    }

    private static ProductVM getProduct(Product product) {
        return ProductMapper.toVM(product);
    }

    public static List<CoolingSystemVM> toVMList(List<CoolingSystem> coolingSystems) {
        return coolingSystems
                .stream()
                .map(CoolingSystemMapper::toVM)
                .collect(Collectors.toList());
    }
}

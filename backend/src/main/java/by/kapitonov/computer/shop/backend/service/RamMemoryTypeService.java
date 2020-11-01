package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.detail.RamMemoryType;

import java.util.List;

public interface RamMemoryTypeService {

    List<RamMemoryType> getAll();

    RamMemoryType getByMemoryTypeName(String typeName);

    RamMemoryType create(String typeName);

}

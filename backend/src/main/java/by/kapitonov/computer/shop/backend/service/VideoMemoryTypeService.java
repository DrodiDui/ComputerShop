package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.detail.VideoMemoryType;

import java.util.List;

public interface VideoMemoryTypeService {

    List<VideoMemoryType> getAll();

    VideoMemoryType findByTypeName(String typeName);

    VideoMemoryType create(String typeName);

}

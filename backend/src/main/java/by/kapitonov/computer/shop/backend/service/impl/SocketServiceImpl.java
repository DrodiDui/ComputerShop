package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductDetailsAlreadyExists;
import by.kapitonov.computer.shop.backend.exception.ProductDetailsNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.detail.Socket;
import by.kapitonov.computer.shop.backend.repository.SocketRepository;
import by.kapitonov.computer.shop.backend.service.SocketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocketServiceImpl implements SocketService {

    private final SocketRepository socketRepository;

    public SocketServiceImpl(SocketRepository socketRepository) {
        this.socketRepository = socketRepository;
    }

    @Override
    public List<Socket> getAll() {
        List<Socket> sockets = socketRepository.findAll();

        if (sockets.isEmpty()) {
            throw new ProductDetailsNotFoundException("Sockets haven't been found");
        }

        return sockets;
    }

    @Override
    public Socket getSocketByName(String socketName) {
        return socketRepository.findBySocketName(socketName)
                .orElseThrow(
                        () -> new ProductDetailsNotFoundException("Socket hasn't been found")
                );
    }

    @Override
    public Socket create(String socketName) {
        if (socketRepository.existsBySocketName(socketName)) {
            throw new ProductDetailsAlreadyExists("Socket already exists");
        }
        return socketRepository.save(new Socket(socketName));
    }
}

package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.detail.Socket;

import java.util.List;

public interface SocketService {

    List<Socket> getAll();

    Socket getSocketByName(String socketName);

    Socket create(String socketName);

}

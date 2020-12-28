package by.kapitonov.computer.shop.backend.rest.controller.product;

import by.kapitonov.computer.shop.backend.service.SocketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sockets")
public class SocketRestController {

    private final SocketService socketService;


    public SocketRestController(SocketService socketService) {
        this.socketService = socketService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllSocketNames() {

        List<String> socketNames = socketService.getAllSocketNames();

        return new ResponseEntity<>(socketNames, HttpStatus.OK);
    }
}
package by.kapitonov.computer.shop.backend.rest.controller;

import by.kapitonov.computer.shop.backend.model.Order;
import by.kapitonov.computer.shop.backend.rest.vm.ApiResponse;
import by.kapitonov.computer.shop.backend.service.OrderService;
import by.kapitonov.computer.shop.backend.service.dto.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    /*@GetMapping
    public ResponseEntity<List<Order>> getAllCurrentUserOrders() {

        List<Order> orders = orderService.getAllOrdersForCurrentUser();

        return new ResponseEntity(orders, HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable(name = "id") Long id) {

        Order order = orderService.getOneOrder(id);

        return new ResponseEntity(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createOrder(@RequestBody OrderDTO orderDTO) {

        orderService.create(orderDTO);

        return new ResponseEntity<>(new ApiResponse("Order successfully created"), HttpStatus.OK);
    }
}

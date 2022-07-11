package com.capgemini.pcshop.controller;

import com.capgemini.pcshop.data.Order;
import com.capgemini.pcshop.data.Part;
import com.capgemini.pcshop.data.PartsMapper;
import com.capgemini.pcshop.service.OrderService;
import com.capgemini.pcshop.service.PartsService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/*TODO: List all parts as json */
@RestController
@RequestMapping("api/v1/parts")
public class PartsController {

    final PartsService partsService;
    final OrderService orderService;
    final PartsMapper partsMapper;

    public PartsController(PartsService partsService, OrderService orderService, PartsMapper partsMapper) {
        this.partsService = partsService;
        this.orderService = orderService;
        this.partsMapper = partsMapper;
    }

//    @GetMapping
//    public String getParts() throws PartsMappingException {
//        return partsMapper.toCollectionDto(partsService.getParts());
//    }

    @GetMapping("all")
    public List<Part> getParts() {
        return new ArrayList<>(partsService.getParts());
    }

    @GetMapping
    public Part getPart(@RequestParam int id) {
        try {
            return partsService.getPartById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @PostMapping("order")
    public Order createOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

}

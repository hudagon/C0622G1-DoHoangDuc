package com.C0622G1.controller;

import com.C0622G1.model.CarHost;
import com.C0622G1.model.Ticket;
import com.C0622G1.service.carhost.ICarHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/carHost/v1")
public class CarHostRestController {

    @Autowired
    private ICarHostService carHostService;

    @GetMapping("/list")
    public ResponseEntity<List<CarHost>> getTicketListAll() {
        return new ResponseEntity<>((List<CarHost>) carHostService.findAll(), HttpStatus.OK);
    }


}

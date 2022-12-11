package com.C0622G1.controller;

import com.C0622G1.dto.TicketDto;
import com.C0622G1.model.Ticket;
import com.C0622G1.service.ticket.ITicketService;
import com.C0622G1.validation.TicketByRequestDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/ticket/v1")
public class TicketRestController {

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private TicketByRequestDtoValidator ticketByRequestDtoValidator;

    @GetMapping("/getListPaged")
    public ResponseEntity<List<Ticket>> getTicketListPaged(
            @RequestParam(required = false, defaultValue = "") String searchStartPoint,
            @RequestParam(required = false, defaultValue = "") String searchEndPoint,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "3") Integer size,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortOrder
    ) {

        Sort sortable = null;

        if (sortOrder.equals("ASC")) {
            sortable = Sort.by(sortBy).ascending();
        }
        if (sortOrder.equals("DESC")) {
            sortable = Sort.by(sortBy).descending();
        }


        Pageable pageable = PageRequest.of(page, size, sortable);

        return new ResponseEntity<>(ticketService.findAll(searchStartPoint, searchEndPoint,
                pageable), HttpStatus.OK);
    }

    @GetMapping("/getListAll")
    public ResponseEntity<List<Ticket>> getTicketListAll(
            @RequestParam(required = false, defaultValue = "") String searchStartPoint,
            @RequestParam(required = false, defaultValue = "") String searchEndPoint
    ) {
        return new ResponseEntity<>(ticketService.findAll(searchStartPoint, searchEndPoint), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketATBC) {
        ticketService.create(ticketATBC);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketBtId(@PathVariable String id) {
        return new ResponseEntity<>(ticketService.findById(Integer.valueOf(id)).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTickById(@PathVariable String id) {
        ticketService.remove(Integer.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> editTickById(@RequestBody TicketDto ticketATBE) {
        ticketService.edit(ticketATBE);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package com.C0622G1.service.ticket;

import com.C0622G1.dto.TicketDto;
import com.C0622G1.model.Ticket;
import com.C0622G1.repository.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements ITicketService {

    @Autowired
    private ITicketRepository ticketRepository;

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return ticketRepository.search(pageable);
    }

    @Override
    public List<Ticket> findAll(String searchStartPoint, String searchEndPoint,
                                Pageable pageable) {

        return ticketRepository.search(searchStartPoint, searchEndPoint,
                 pageable);
    }

    @Override
    public List<Ticket> findAll(String searchStartPoint, String searchEndPoint) {
        return ticketRepository.getAll(searchStartPoint, searchEndPoint);
    }

    @Override
    public Iterable<Ticket> findAll() {
        return null;
    }

    @Override
    public Optional<Ticket> findById(Integer id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return null;
    }

    @Override
    public void create(TicketDto ticket) {
        ticketRepository.create(
                ticket.getId(),
                ticket.getEndPoint(),
                ticket.getPrice(),
                ticket.getStartDate(),
                ticket.getStartPoint(),
                ticket.getStartTime(),
                ticket.getCarHostId(),
                ticket.getAmount());
    }

    @Override
    public void edit(TicketDto ticket) {
        ticketRepository.edit(
                ticket.getId(),
                ticket.getEndPoint(),
                ticket.getPrice(),
                ticket.getStartDate(),
                ticket.getStartPoint(),
                ticket.getStartTime(),
                ticket.getCarHostId(),
                ticket.getAmount());
    }

    @Override
    public void remove(Integer id) {
        ticketRepository.deleteById(id);
    }

}

package com.C0622G1.service.ticket;

import com.C0622G1.dto.TicketDto;
import com.C0622G1.model.Ticket;
import com.C0622G1.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITicketService extends IGeneralService<Ticket> {
    Page<Ticket> findAll(Pageable pageable);

    List<Ticket> findAll(String searchStartPoint, String searchEndPoint,
                         Pageable pageable);

    List<Ticket> findAll(String searchStartPoint, String searchEndPoint);

    void create(TicketDto ticket);

    void edit(TicketDto ticket);
}

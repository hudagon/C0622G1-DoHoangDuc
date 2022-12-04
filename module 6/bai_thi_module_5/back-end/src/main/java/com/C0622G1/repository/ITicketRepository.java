package com.C0622G1.repository;

import com.C0622G1.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(
            value = " select * from ticket ",
            nativeQuery = true
    )
    Page<Ticket> search(Pageable pageable);

    @Query(
            value = " select * from ticket where ticket.start_point " +
                    " like %:searchStartPoint% and ticket.end_point " +
                    " like %:searchEndPoint% ",
            nativeQuery = true
    )
    List<Ticket> search(@Param("searchStartPoint") String searchStartPoint,
                        @Param("searchEndPoint") String searchEndPoint,
                        Pageable pageable);

    @Query(
            value = " select * from ticket where ticket.start_point " +
                    " like %:searchStartPoint% and ticket.end_point " +
                    " like %:searchEndPoint% ",
            nativeQuery = true
    )
    List<Ticket> getAll(@Param("searchStartPoint") String searchStartPoint,
                        @Param("searchEndPoint") String searchEndPoint);


    @Modifying
    @Query(value = " insert into ticket(id, end_point, price, start_date, start_point, start_time, car_host_id, amount) " +
            " value (:id, :endPoint, :price, :startDate, :startPoint, :startTime, :carHostId, :amount) ", nativeQuery = true)
    void create(@Param("id") Integer id,
              @Param("endPoint") String endPoint,
              @Param("price") Double price,
              @Param("startDate") String startDate,
              @Param("startPoint") String startPoint,
              @Param("startTime") String startTime,
              @Param("carHostId") Integer carHostId,
              @Param("amount") Integer amount);

    @Modifying
    @Query(value = " update `bai_thi_module_5`.`ticket` set `end_point` = :endPoint , " +
            " `price` = :price , `start_date` = :startDate , " +
            " `start_point` = :startPoint , `start_time` = :startTime , " +
            " `car_host_id` = :carHostId , `amount` = :amount where (`id` = :id) ", nativeQuery = true)
    void edit(@Param("id") Integer id,
                @Param("endPoint") String endPoint,
                @Param("price") Double price,
                @Param("startDate") String startDate,
                @Param("startPoint") String startPoint,
                @Param("startTime") String startTime,
                @Param("carHostId") Integer carHostId,
                @Param("amount") Integer amount);
}

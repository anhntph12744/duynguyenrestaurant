package com.restarant.backend.repository;

import com.restarant.backend.entity.OrderDetails;
import com.restarant.backend.entity.OrderTotal;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the OrderTotal entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderTotalRepository extends JpaRepository<OrderTotal, Long> {
    @Query("select o from OrderDetails o where o.tableOrder.orderTotal.id = :id and o.status= :status")
    List<OrderDetails> getOrderdetailbyTotalAndStatus(@Param("id") Long id,@Param("status") Integer status);

    @Query("SELECT o FROM OrderTotal o WHERE o.customer.id = :id AND o.status = 0")
    OrderTotal getOrderTotalByCustomerId(Long id);

    @Query("SELECT o FROM OrderTotal o WHERE o.customer.id = :id AND o.status = :status")
    List<OrderTotal> getListOrderTotalByCustomerId(Long id, Integer status);

    @Query("SELECT o FROM OrderTotal o ")
    List<OrderTotal> getListOrderTotalBetweenTime(long fromTime, long toTime, Integer status);

    OrderTotal findByVoucherAndCustomerIdAndStatus(Long voucherId, Long customerId, Integer status);
}

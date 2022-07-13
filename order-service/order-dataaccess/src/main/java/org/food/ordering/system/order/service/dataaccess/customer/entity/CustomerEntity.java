package org.food.ordering.system.order.service.dataaccess.customer.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_customer_m_view", schema = "customer")
@Entity
//This entity will be used just to check if the customer exists or not
public class CustomerEntity {
    @Id
    private UUID id;
}

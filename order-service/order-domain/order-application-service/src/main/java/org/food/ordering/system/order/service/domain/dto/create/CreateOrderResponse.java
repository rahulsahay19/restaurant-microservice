package org.food.ordering.system.order.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.food.ordering.system.domain.valueobject.OrderStatus;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
    @NotNull
    public final UUID orderTrackingId;
    @NotNull
    public final OrderStatus orderStatus;
    @NotNull
    public final String message;
}

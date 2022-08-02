import lombok.extern.slf4j.Slf4j;
import org.food.ordering.system.payment.service.domain.dto.PaymentRequest;
import org.food.ordering.system.payment.service.domain.event.PaymentEvent;
import org.food.ordering.system.payment.service.domain.ports.input.message.listener.PaymentRequestMessageListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentRequestMessageListenerImpl implements PaymentRequestMessageListener {
    //Here, I create helper component to call the repository component
    //and then call the helper class to persist data in local repository
    private final PaymentRequestHelper paymentRequestHelper;


    public PaymentRequestMessageListenerImpl(PaymentRequestHelper paymentRequestHelper) {
        this.paymentRequestHelper = paymentRequestHelper;

    }

    @Override
    public void completePayment(PaymentRequest paymentRequest) {
        PaymentEvent paymentEvent = paymentRequestHelper.persistPayment(paymentRequest);
        fireEvent(paymentEvent);

    }

    @Override
    public void cancelPayment(PaymentRequest paymentRequest) {
        PaymentEvent paymentEvent = paymentRequestHelper.persistCancelPayment(paymentRequest);
        fireEvent(paymentEvent);
    }

    private void fireEvent(PaymentEvent paymentEvent) {
        log.info("Publishing payment event with payment id: {} and order id: {}",
                paymentEvent.getPayment().getId().getValue(),
                paymentEvent.getPayment().getOrderId().getValue());
        paymentEvent.fire();
    }
}

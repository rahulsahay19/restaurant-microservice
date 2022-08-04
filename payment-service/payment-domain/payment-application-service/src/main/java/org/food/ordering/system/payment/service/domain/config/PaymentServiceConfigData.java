package org.food.ordering.system.payment.service.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "payment-service") //This will be fed from application.yml
public class PaymentServiceConfigData {
    private String paymentRequestTopicName;
    private String paymentResponseTopicName;
}

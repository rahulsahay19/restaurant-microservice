package org.food.ordering.system.payment.service.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    //I want to use this payment domain service from other modules
    @Bean
    public PaymentDomainService paymentDomainService() {
        return new PaymentDomainServiceImpl();
    }
}

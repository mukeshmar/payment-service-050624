package in.mukesh.paymentservice050624.service.paymentGateway;

import in.mukesh.paymentservice050624.dto.PaymentLinkDTO;

public interface PaymentGateway {
    public PaymentLinkDTO generatePaymentLink(String orderId, long amount);
}

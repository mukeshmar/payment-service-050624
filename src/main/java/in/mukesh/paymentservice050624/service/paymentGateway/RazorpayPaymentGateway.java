package in.mukesh.paymentservice050624.service.paymentGateway;

import in.mukesh.paymentservice050624.dto.PaymentLinkDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("RazorpayPaymentGateway")
public class RazorpayPaymentGateway implements PaymentGateway {
    @Override
    public PaymentLinkDTO generatePaymentLink(String orderId, long amount) {
        return null;
    }
}

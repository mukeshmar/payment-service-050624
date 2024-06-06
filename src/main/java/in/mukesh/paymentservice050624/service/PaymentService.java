package in.mukesh.paymentservice050624.service;

import com.razorpay.RazorpayException;
import in.mukesh.paymentservice050624.dto.PaymentLinkDTO;
import in.mukesh.paymentservice050624.service.paymentGateway.PaymentGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentGateway paymentGateway;
    public PaymentService(@Qualifier("RazorpayPaymentGateway") PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public PaymentLinkDTO generatePaymentLink(String orderId, long amount) throws RazorpayException {
        return paymentGateway.generatePaymentLink(orderId, amount);
    }
}

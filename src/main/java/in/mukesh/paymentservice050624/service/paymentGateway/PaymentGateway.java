package in.mukesh.paymentservice050624.service.paymentGateway;

import com.razorpay.RazorpayException;
import in.mukesh.paymentservice050624.dto.PaymentLinkDTO;

public interface PaymentGateway {
    public PaymentLinkDTO generatePaymentLink(String orderId, long amount) throws RazorpayException;
}

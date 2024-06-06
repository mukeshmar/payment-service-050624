package in.mukesh.paymentservice050624.service.paymentGateway;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import in.mukesh.paymentservice050624.dto.PaymentLinkDTO;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
@Qualifier("RazorpayPaymentGateway")
public class RazorpayPaymentGateway implements PaymentGateway {

    private final RazorpayClient razorpayClient;

    public RazorpayPaymentGateway(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }

    @Override
    public PaymentLinkDTO generatePaymentLink(String orderId, long amount) throws RazorpayException {

        // Source: https://razorpay.com/docs/api/payments/payment-links/create-standard/

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount * 100); // amount
        paymentLinkRequest.put("currency", "INR");

        // Set expire_by to 15 minutes in the future (in milliseconds)
        long currentTimeMillis = Instant.now().toEpochMilli();
        long expireByMillis = currentTimeMillis + 15 * 60 * 1000;

        paymentLinkRequest.put("reference_id", orderId);
        paymentLinkRequest.put("description", "Payment for order id: " + orderId);

        JSONObject customer = new JSONObject();
        customer.put("name", "Mukesh Mar");
        customer.put("contact", "+91 914061640");
        customer.put("email", "mukeshmar0710@gmail.com");

        paymentLinkRequest.put("customer", customer);

        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);

        paymentLinkRequest.put("notify", notify);
        paymentLinkRequest.put("reminder_enable", true);

        JSONObject notes = new JSONObject();
        notes.put("policy_name", "Scaler");

        paymentLinkRequest.put("notes", notes);
        paymentLinkRequest.put("callback_url", "https://www.scaler.com");
        paymentLinkRequest.put("callback_method", "get");

        // Create payment link
        PaymentLink paymentLink = razorpayClient.paymentLink.create(paymentLinkRequest);

        PaymentLinkDTO paymentLinkDTO = new PaymentLinkDTO();
        paymentLinkDTO.setPaymentLink(paymentLink.toString());
        return paymentLinkDTO;
    }
}

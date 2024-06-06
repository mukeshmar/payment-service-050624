package in.mukesh.paymentservice050624.controller;


import com.razorpay.RazorpayException;
import in.mukesh.paymentservice050624.dto.CreatePaymentRequestDTO;
import in.mukesh.paymentservice050624.dto.PaymentLinkDTO;
import in.mukesh.paymentservice050624.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping({"/payments", "/payments/"})
    public ResponseEntity<PaymentLinkDTO> InitializePayment(@RequestBody CreatePaymentRequestDTO createPaymentRequestDTO) throws RazorpayException {
        PaymentLinkDTO paymentLinkDTO = paymentService.generatePaymentLink(
                createPaymentRequestDTO.getOrderId(),
                createPaymentRequestDTO.getAmount()
        );
        return ResponseEntity.status(HttpStatus.OK).body(paymentLinkDTO);
    }
}

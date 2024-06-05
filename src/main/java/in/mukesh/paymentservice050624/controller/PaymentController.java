package in.mukesh.paymentservice050624.controller;


import in.mukesh.paymentservice050624.dto.CreatePaymentRequestDTO;
import in.mukesh.paymentservice050624.dto.PaymentLinkDTO;
import in.mukesh.paymentservice050624.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping({"/payments", "/payments/"})
    public PaymentLinkDTO InitializePayment(@RequestBody CreatePaymentRequestDTO createPaymentRequestDTO){
        return null;
    }
}

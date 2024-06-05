package in.mukesh.paymentservice050624.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentRequestDTO {
    private String orderId;
    private long amount;
}

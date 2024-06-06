package in.mukesh.paymentservice050624.advice;


import com.razorpay.RazorpayException;
import in.mukesh.paymentservice050624.dto.PaymentExceptionDto;
import in.mukesh.paymentservice050624.dto.PaymentLinkDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RazorpayException.class)
    public ResponseEntity<PaymentExceptionDto> handleRazorPayException(RazorpayException razorpayException) {
        String msg = "Error in RazorPay payment, reason: " + razorpayException.getMessage();
        PaymentExceptionDto paymentExceptionDto = new PaymentExceptionDto();
        paymentExceptionDto.setErrorMessage(msg);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(paymentExceptionDto);
    }
}

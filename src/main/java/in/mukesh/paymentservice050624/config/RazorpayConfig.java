package in.mukesh.paymentservice050624.config;


import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {
    @Value("${razorPay.api.id}")
    private String razorPayApiId;

    @Value("${razorPay.key.secret}")
    private String razorPayKeySecret;

    @Bean
    public RazorpayClient createRazorpayClient() throws RazorpayException {
        return new RazorpayClient(razorPayApiId, razorPayKeySecret);
    }
}

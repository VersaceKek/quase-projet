public class PaymentGateway {
    private static PaymentGateway instance = new PaymentGateway();

    private PaymentGateway() {
        // Configurações de inicialização do gateway de pagamento
    }

    public static PaymentGateway getInstance() {
        return instance;
    }

    public PaymentResponse processPayment(PaymentRequest request) {
        // Lógica de processamento de pagamento aqui
    }
}

public interface PaymentStrategy {
    PaymentResponse processPayment(PaymentRequest request);
}

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        // Lógica específica para pagamento com cartão de crédito
    }
}

public class PayPalPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        // Lógica específica para pagamento com PayPal
    }
}

public class PaymentFacade {
    private PaymentStrategy paymentStrategy;

    public PaymentFacade(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentResponse processPayment(PaymentRequest request) {
        // Lógica para direcionar a solicitação ao gateway de pagamento e usar a estratégia apropriada
    }
}

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentFacade paymentFacade;

    @Autowired
    public PaymentController(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @PostMapping("/credit-card")
    public PaymentResponse processCreditCardPayment(@RequestBody PaymentRequest request) {
        return paymentFacade.processPayment(request);
    }

    @PostMapping("/paypal")
    public PaymentResponse processPayPalPayment(@RequestBody PaymentRequest request) {
        return paymentFacade.processPayment(request);
    }
}

package com.nttdata.bootcamp.microservicio4.expose;

import com.nttdata.bootcamp.microservicio4.business.TransactionService;
import com.nttdata.bootcamp.microservicio4.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "20000")
class TransactionControllerTest {
    @MockBean
    private TransactionService transactionService;
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private TransactionController transactionController;

    private static final Credit credit = new Credit();
    private static final Account account = new Account();
    private static final Customer customer = new Customer();
    private static final CustomerType customerType = new CustomerType();
    private static final Transaction mockTransaction = new Transaction();
    private static final TransactionType transactionType = new TransactionType();
    private static final List<Transaction> transactionListMock = new ArrayList<>();
    private static final String id = "c01256626";
    private static final double amount = 120.50;
    private static final LocalDate date = LocalDate.parse("2022-01-25");;
    private static final String status = "ACTIVO";
    private static final String transactionTypeCodigo = "001";
    private static final String transactionTypeDescription = "Deposito";
    private static final String accountId = "a5d41fd1";
    private static final String accountAccountNumber = "421375896253";
    private static final String accountCurrency = "Soles";
    private static final Double accountAmountAvailable = 0.0;
    private static final String creditId = "byi2k4ksls";
    private static final String creditCardNumber = "4213 2563 1002 5896";
    private static final double creditCreditLimit = 1400;
    private static final LocalDate creditPaymentDate = LocalDate.parse("2022-01-31");;
    private static final String  creditStatus = "ACTIVO";
    private static final double creditamountAvailable = 800;
    private static final double creditamountConsumed = 600;
    private final static String customerId = "61d874f0dsf";
    private final static String customerFirstName = "Jose Luis";
    private final static String customerLastName = "Peralta";
    private final static String customerEmail = "joseluis@gmail.com";
    private final static String customerNumberDocumentIdentity = "72159854";
    private final static String customerTypeDescription = "72159854";

    @BeforeEach
    void setUp() {
        mockTransaction.setId(id);
        mockTransaction.setAmount(amount);
        mockTransaction.setDate(date);
        mockTransaction.setStatus(status);
        transactionType.setCodigo(transactionTypeCodigo);
        transactionType.setDescription(transactionTypeDescription);
        mockTransaction.setTransactionType(transactionType);
        account.setId(accountId);
        account.setAccountNumber(accountAccountNumber);
        account.setCurrency(accountCurrency);
        account.setAmountAvailable(accountAmountAvailable);
        mockTransaction.setAccount(account);
        credit.setId(creditId);
        credit.setCardNumber(creditCardNumber);
        credit.setCreditLimit(creditCreditLimit);
        credit.setPaymentDate(creditPaymentDate);
        credit.setStatus(creditStatus);
        credit.setAmountAvailable(creditamountAvailable);
        credit.setAmountConsumed(creditamountConsumed);
        customer.setId(customerId);
        customer.setFirstname(customerFirstName);
        customer.setLastname(customerLastName);
        customer.setEmail(customerEmail);
        customer.setNumberDocumentIdentity(customerNumberDocumentIdentity);
        customerType.setDescription(customerTypeDescription);
        customer.setCustomerType(customerType);
        credit.setCustomer(customer);
        account.setCustomer(customer);
        mockTransaction.setCredit(credit);
        transactionListMock.add(mockTransaction);
    }

    @Test
    void getCustomer() {
    }

    @Test
    void getCredit() {
    }

    @Test
    void getAccount() {
    }

    @Test
    void byId() {
        log.info("--Metodo GET: Obtener una transaccion por ID--");
        Mockito.when(transactionService.findById(id)).thenReturn(Mono.just(mockTransaction));

        webTestClient.get().uri("/api/v1/transactions/" + id)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void findAll() {
        log.info("--Metodo GET: Obtener todas las transacciones registradas--");
        Mockito.when(transactionService.findAll()).thenReturn(Flux.fromIterable(transactionListMock));

        webTestClient.get().uri("/api/v1/transactions/all")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void create() {
        log.info("--Metodo POST: Realizar una transacción--");
        Mockito.when(transactionService.create(mockTransaction)).thenReturn(Mono.just(mockTransaction));
    }

    @Test
    void update() {
        log.info("--Metodo UPDATE: Actualizar una transaccion--");
        Mockito.when(transactionService.update(mockTransaction)).thenReturn(Mono.just(mockTransaction));
    }

    @Test
    void delete() {
        log.info("--Metodo DELETE: Eliminar una transaccion:");
        Mockito.when(transactionService.remove(id)).thenReturn(Mono.just(mockTransaction));

        webTestClient.delete().uri("/api/v1/transactions/" + id)
                .exchange()
                .expectStatus().isOk();
    }
}
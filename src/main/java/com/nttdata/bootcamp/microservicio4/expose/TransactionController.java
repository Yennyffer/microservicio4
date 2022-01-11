package com.nttdata.bootcamp.microservicio4.expose;

import com.nttdata.bootcamp.microservicio4.model.Transaction;
import com.nttdata.bootcamp.microservicio4.model.Customer;
import com.nttdata.bootcamp.microservicio4.model.Credit;
import com.nttdata.bootcamp.microservicio4.model.Account;
import com.nttdata.bootcamp.microservicio4.business.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link TransactionController}<br/>
 * <b>Copyright</b>: &Copy; 2022 NTT DATA SAC. <br/>
 * <b>Company</b>: NTT DATA SAC. <br/>
 *
 * @author Yennyffer Lizana <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>{USERNAME}. (acronym) From (YEN)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>ene. 11, 2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */

@RestController
@Slf4j
public class TransactionController {

  @Autowired
  private TransactionService transactionService;
  
  @GetMapping("/api/customers")
  public Flux<Customer> getCustomer() {
    log.info("byCustomerAll>>>>>");
    return transactionService.findCustomerAll();
  }
  
  @GetMapping("/api/credits")
  public Flux<Credit> getCredit() {
    log.info("byCreditAll>>>>>");
    return transactionService.findCreditAll();
  }
  
  @GetMapping("/api/accounts")
  public Flux<Account> getAccount() {
    log.info("byAccountAll>>>>>");
    return transactionService.findAccountAll();
  }

  @GetMapping("/api/transactions/{id}")
  public Mono<Transaction> byId(@PathVariable("id") String id) {
    log.info("byId>>>>>");
    return transactionService.findById(id);
  }
  
  @GetMapping("/api/transactions-all")
  public Flux<Transaction> findAll() {
    log.info("findAll>>>>>");

    return transactionService.findAll();
  }

  @PostMapping("/api/transaction/create")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Transaction> create(@RequestBody Transaction transaction) {
    log.info("create>>>>>");
    return transactionService.create(transaction);
  }

  @PutMapping("/api/transaction/update")
  public Mono<ResponseEntity<Transaction>> update(@RequestBody Transaction transaction) {
    log.info("update>>>>>");
    return transactionService.update(transaction)
        .flatMap(transactionUpdate -> Mono.just(ResponseEntity.ok(transactionUpdate)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @PatchMapping("/api/transactions")
  public Mono<ResponseEntity<Transaction>> change(@RequestBody Transaction transaction) {
    log.info("change>>>>>");
    return transactionService.change(transaction)
        .flatMap(transactionUpdate -> Mono.just(ResponseEntity.ok(transactionUpdate)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @DeleteMapping("/api/transactions/{id}")
  public Mono<ResponseEntity<Transaction>> delete(@PathVariable("id") String id) {
    log.info("delete>>>>>");
    return transactionService.remove(id)
        .flatMap(transaction -> Mono.just(ResponseEntity.ok(transaction)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }
  
}


package com.nttdata.bootcamp.microservicio4.business.impl;

import com.nttdata.bootcamp.microservicio4.model.Customer;
import com.nttdata.bootcamp.microservicio4.model.Credit;
import com.nttdata.bootcamp.microservicio4.model.Account;
import com.nttdata.bootcamp.microservicio4.business.TransactionService;
import com.nttdata.bootcamp.microservicio4.model.Transaction;
import com.nttdata.bootcamp.microservicio4.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link TransactionServiceImpl}<br/>
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

@Service
public class TransactionServiceImpl implements TransactionService{

  @Autowired
  private TransactionRepository transactionRepository;
  @Autowired
  private WebClient webClientUser;


  @Override
  public Mono<Transaction> create(Transaction transaction) {

    if(!transaction.getId().isBlank()){
    	
    }

    return transactionRepository.save(transaction);
  }

  @Override
  public Mono<Transaction> findById(String transactionId) {
    return transactionRepository.findById(transactionId);
  }

  @Override
  public Flux<Transaction> findAll() {
    return transactionRepository.findAll();
  }

  @Override
  public Mono<Transaction> update(Transaction transaction) {
	  return transactionRepository.save(transaction);
  }

  @Override
  public Mono<Transaction> change(Transaction transaction) {
    return transactionRepository.findById(transaction.getId())
        .flatMap(transactionDB -> {
          return create(transaction);
        })
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<Transaction> remove(String transactionId) {
    return transactionRepository
        .findById(transactionId)
        .flatMap(p -> transactionRepository.deleteById(p.getId()).thenReturn(p));

  }
  
  @Override
  public Flux<Customer> findCustomerAll() {
    return webClientUser.get()
        .uri(uriBuilder -> uriBuilder
            .path("customers-all/" )
            .build())
        .retrieve()
        .bodyToFlux(Customer.class);
  }
  
  @Override
  public Flux<Credit> findCreditAll() {
    return webClientUser.get()
        .uri(uriBuilder -> uriBuilder
            .path("credits-all/" )
            .build())
        .retrieve()
        .bodyToFlux(Credit.class);
  }
  
  @Override
  public Flux<Account> findAccountAll() {
    return webClientUser.get()
        .uri(uriBuilder -> uriBuilder
            .path("accounts-all/" )
            .build())
        .retrieve()
        .bodyToFlux(Account.class);
  }

}

package com.nttdata.bootcamp.microservicio4.business;

import com.nttdata.bootcamp.microservicio4.model.Customer;
import com.nttdata.bootcamp.microservicio4.model.Credit;
import com.nttdata.bootcamp.microservicio4.model.Account;
import com.nttdata.bootcamp.microservicio4.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link TransactionService}<br/>
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

public interface TransactionService {

    Mono<Transaction> create(Transaction transaction);
  
    Mono<Transaction> findById(String transactionId);
  
    Flux<Transaction> findAll();
  
    Mono<Transaction> update(Transaction transaction);
  
    Mono<Transaction> change(Transaction transaction);
  
    Mono<Transaction> remove(String transactionId);
    
    Flux<Customer> findCustomerAll();
    
    Flux<Credit> findCreditAll();
    
    Flux<Account> findAccountAll();
    
  
  }
  



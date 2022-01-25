package com.nttdata.bootcamp.microservicio4.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link Transaction}<br/>
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


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Document(collection = "transaction")

public class Transaction {
    @Id
    private String id = UUID.randomUUID().toString();
    private double amount;
    private LocalDate date;
    private TransactionType transactionType;
    private Credit credit;
    private Account account;
    private String status;
    
    
}

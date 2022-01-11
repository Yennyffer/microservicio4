package com.nttdata.bootcamp.microservicio4.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link Credit}<br/>
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

public class Credit {
    
    private String id;
    private String cardNumber;
    private double creditLimit;
    private Date paymentDate;
    private boolean isActive;
    private double amountAvailable;
    private double amountConsumed;
    private CreditType creditType;
    private Customer customer;
    
}

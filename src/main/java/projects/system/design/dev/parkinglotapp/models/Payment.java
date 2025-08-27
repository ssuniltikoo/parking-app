package projects.system.design.dev.parkinglotapp.models;

import lombok.Getter;
import lombok.Setter;
import projects.system.design.dev.parkinglotapp.models.enums.PaymentMode;
import projects.system.design.dev.parkinglotapp.models.enums.PaymentStatus;

import java.util.Date;

@Getter
@Setter
public class Payment extends BaseModel{
    private Date date;
    private double amount;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private Bill bill;
    private String billRefNo;
}

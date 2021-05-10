package car_rental;

import enum_type.PaymentMethod;
import java.time.LocalDateTime;
public class Payment {
	public String paymentItem;
	public double amount;
	public PaymentMethod paymentmethod;
	public LocalDateTime paymentDateTime;
	public String creaditCardDetail;
	public Payment( String paymentItem, 
					double amount,
					PaymentMethod paymentmethod, 
					LocalDateTime paymentDateTime,
					String creaditCardDetail) {
		this.paymentItem = paymentItem;
		this.amount = amount;
		this.paymentmethod = paymentmethod;
		this.paymentDateTime = paymentDateTime;
		this.creaditCardDetail = creaditCardDetail;
	}
	
}

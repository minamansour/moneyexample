package com;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

/*
 * @Auther Mina Mansour
 * @Date 25/08/2017
 */
public final class Money {

	private Currency currency;
	private BigDecimal amount;
	private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;

	public Money(String amount, String currencyCode) {
		this(new BigDecimal(amount), Currency.getInstance(currencyCode));
	}

	public Money(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
		this.amount.setScale(currency.getDefaultFractionDigits(), DEFAULT_ROUNDING);
	}

	public Money multiplyBy(int factor) {
		return new Money(getAmount().multiply(new BigDecimal(factor)), getCurrency());
	}

	public Currency getCurrency() {
		return currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return getAmount() + " " + getCurrency().getCurrencyCode();
	}

	public static void main(String[] args) {
		Money moneyInEUR = new Money("67.89", "EUR");
		Money moneyInUSD = new Money("98.76", "USD");

		System.out.println(moneyInEUR);
		System.out.println(moneyInEUR.multiplyBy(3));
		System.out.println(moneyInUSD);
		System.out.println(moneyInUSD.multiplyBy(4));
	}
}
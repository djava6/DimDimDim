package br.com.useinet.util;

import java.text.NumberFormat;
import java.util.Locale;

public class Decimal {
	
	private String valor;
	private double decimal;
	
	public Decimal(double valor){
    	NumberFormat decimal =  NumberFormat.getNumberInstance(Locale.ITALY);
    	decimal.setMinimumIntegerDigits(1);
    	decimal.setMaximumIntegerDigits(12);
    	decimal.setMinimumFractionDigits(2);
    	decimal.setMaximumFractionDigits(2);
    	setValor(decimal.format(valor));
    }
	
	public Decimal(String decimal){
		String valor = decimal.replaceAll("[.]", "");
		valor = valor.replace(',', '.');
    	setDecimal(Double.parseDouble(valor));
    }
	
    public double getDecimal() {
		return decimal;
	}

	public void setDecimal(double decimal) {
		this.decimal = decimal;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
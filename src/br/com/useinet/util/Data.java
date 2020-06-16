package br.com.useinet.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;

public class Data {
	
	private String valor;
	private Date data;
	
    public Data(Date data){
    	DateFormat dateFormat =  DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
    	setValor(dateFormat.format(data));
    }
    
    public Data(String valor) {
    	StringTokenizer tokenizer = new StringTokenizer(valor, "/");    	
    	int dia = Integer.parseInt(tokenizer.nextToken());
    	int mes = Integer.parseInt(tokenizer.nextToken());
    	int ano = Integer.parseInt(tokenizer.nextToken());
    	int anoAtual = (new GregorianCalendar().get(Calendar.YEAR) / 1000) * 1000;
    	setData(new GregorianCalendar(anoAtual + ano, mes - 1, dia).getTime());
    }

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}

}
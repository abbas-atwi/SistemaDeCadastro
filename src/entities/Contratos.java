package entities;

import java.util.Date;

public class Contratos {

	private Date date;
	private double valorHora;
	private int horas;

	public Contratos() {

	}

	public Contratos(Date date, double valorHora, int horas) {
		this.date = date;
		this.valorHora = valorHora;
		this.horas = horas;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	public double total() {
		return valorHora * horas;
	}

}

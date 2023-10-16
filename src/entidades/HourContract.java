package entidades;

import java.time.LocalDate;

public class HourContract {

	private LocalDate date;
	private Double valor_hora;
	private Integer hora; 
	
	public HourContract() {
		
	}
	
	public HourContract(LocalDate date, Double valor_hora,Integer hora) {
		this.date=date;
		this.hora=hora;
		this.valor_hora=valor_hora;
	}
	
	public Double totalValor() {
		return valor_hora*hora;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getValor_hora() {
		return valor_hora;
	}

	public void setValor_hora(Double valor_hora) {
		this.valor_hora = valor_hora;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}
	
}

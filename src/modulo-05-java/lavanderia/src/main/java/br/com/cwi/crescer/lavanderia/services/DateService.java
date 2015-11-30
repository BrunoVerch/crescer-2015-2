package br.com.cwi.crescer.lavanderia.services;

import java.util.Date;
import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class DateService {

	private Calendar calendar= Calendar.getInstance();
	private int segunda = calendar.MONDAY;
	private int terca = calendar.TUESDAY;
	private int quarta = calendar.WEDNESDAY;
	private int quinta = calendar.THURSDAY;
	private int sexta = calendar.FRIDAY;

	private int diaAtualDaSemana(){
		return calendar.get(calendar.DAY_OF_WEEK);
	}
	public boolean ehQuintaOuSexta(Date data){
		calendar.setTime(data);
		int diaAtual = diaAtualDaSemana();
		return diaAtual == quinta || diaAtual == sexta;
	}
	
	public boolean ehDeSegundaAQuarta(Date data){
		calendar.setTime(data);
		int diaAtual = diaAtualDaSemana();
		return diaAtual >= segunda && diaAtual <= quarta;
	}
}

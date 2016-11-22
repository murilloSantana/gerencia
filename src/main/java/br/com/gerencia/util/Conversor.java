package br.com.gerencia.util;

import java.text.NumberFormat;
import java.text.ParseException;

import org.springframework.stereotype.Component;
@Component
public class Conversor {

	public Double StringToDouble(String valor) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		Double resultado = null;
		try {
			resultado = numberFormat.parse(valor).doubleValue();

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultado;
	}
}

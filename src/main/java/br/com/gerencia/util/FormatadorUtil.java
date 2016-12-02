package br.com.gerencia.util;

import java.text.NumberFormat;
import java.text.ParseException;

import org.springframework.stereotype.Component;
@Component
public class FormatadorUtil {

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
	
	public String formatarVirgula(String valor){
		valor = valor.replace(".", ",");
		return valor;
	}
}

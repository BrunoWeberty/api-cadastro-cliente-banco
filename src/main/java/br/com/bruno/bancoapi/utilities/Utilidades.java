package br.com.bruno.bancoapi.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {
	Date data;
	
	public Date formatarData(String dataEmUmFormato) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			data = formato.parse(dataEmUmFormato);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}

package com.friendlyHand.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TratamentoData {
	
	public String gerarData(){
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		return dateFormat.format(date);
		
	}

}

package mx.com.hdi.util;

import java.util.List;


import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	public static long serviceTime(long tini) {
		Long totalTime = 0L;
		totalTime =System.currentTimeMillis() - tini; 
		return totalTime;
	}
	
	public static String outDAO(List<String> parameters, String function) {
		StringBuilder response = new StringBuilder("");
		for (int i = 0; i < parameters.size(); i++) {
			response.append(parameters.get(i) + " / ");
		}
		response.append(function);
		return response.toString();	
	}

}
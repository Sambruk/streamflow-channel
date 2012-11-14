package se.streamsource.qidsimulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class QidSearch {

	public String search(Map parameters) throws IOException {
		String contactId = (String)parameters.get("contactId");
		if (contactId == null) {
			throw new IllegalArgumentException("Malformed query, no contactId parameter."); 
		}
		String returnValue = findSampleResult(contactId);
		
		return returnValue + "\n" + parameters.toString();
	}

	private String findSampleResult(String contactId) throws IOException {
		
		InputStream in = null;
	    try {
	    	in = this.getClass().getClassLoader().getResourceAsStream("qid-example-"+contactId);
	    
		
		BufferedReader br = new BufferedReader( new InputStreamReader( in )); 
	      String next = br.readLine();
	      StringBuffer buffer = new StringBuffer();
	      while (next != null) {
	         buffer.append( next +"\n" );
	         next = br.readLine();
	      }
	      br.close();
	      return buffer.toString();
	    } catch (Exception e) {
	    	throw new IllegalArgumentException("No such contactId:" + contactId);
	    }
	}
}

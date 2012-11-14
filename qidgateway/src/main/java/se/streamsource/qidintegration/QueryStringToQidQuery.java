package se.streamsource.qidintegration;

import java.util.Map;

import org.mule.MessageExchangePattern;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;


public class QueryStringToQidQuery  {

	public QueryStringToQidQuery() {
		 
	}
	
	public String toQidQueryParams(Object src)
			 {
		Map parameters = (Map)src;
		String contactId = (String)parameters.get("contactId");
		if (contactId == null) {
			System.out.println("toQidQueryParams throwing IllegalArgumentException: " + src);
			throw new IllegalArgumentException("Malformed query");
		}
		System.out.println("toQidQueryParams src: " + src);
				return contactId;
	}

}

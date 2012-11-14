package se.streamsource.qidintegration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class QidGetPersonTest extends FunctionalTestCase {

	@Override
	protected String getConfigResources() {
		return "mule-config.xml";
	}
	
	@Test
    public void testGetPerson() throws Exception
    {
        MuleClient client = muleContext.getClient();
        MuleMessage response = client.send("vm://searchstart", "id=196023222313122", null);
        assertNotNull(response);
        assertTrue(response.getPayloadAsString().length()>10);
        System.out.println(response.getPayload());
    }

}

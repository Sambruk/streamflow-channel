package se.streamsource.streamflow.qidintegration.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import se.streamsource.channel.qidintegration.ContactParser;
import se.streamsource.channel.transport.ContactAddressValue;
import se.streamsource.channel.transport.ContactValue;


public class ContactParserTest
{
   String input;
   @Before
   public void setup() throws IOException {
      
      File file = new File("src/test/resources/qid-example0");
      FileInputStream stream = new FileInputStream( file );
      BufferedReader br = new BufferedReader( new InputStreamReader( stream )); 
      String next = br.readLine();
      StringBuffer buffer = new StringBuffer();
      while (next != null) {
         buffer.append( next +"\n" );
         next = br.readLine();
      }
      
      input = buffer.toString();
      
      br.close();
   }
   @Test
   public void parsePersonContact_VerifyNames() {
     ContactParser parser = new ContactParser();
     ContactValue person = parser.parse( input );
     
     assertEquals( "Pär Gunnar Allan Cardesten", person.getName() );
     
   }
   
   @Test
   public void parsePersonContact_VerifyId() {
     ContactParser parser = new ContactParser();
     ContactValue person = parser.parse( input );
     
     assertEquals( "196003302517", person.getContactId() );
     
   }
   
   @Test
   public void parsePersonContact_VerifyAdress() {
     ContactParser parser = new ContactParser();
     ContactValue person = parser.parse( input );
     List<ContactAddressValue> addresses = person.getAddresses();
     ContactAddressValue address = addresses.get( 0 );
     
     assertTrue(addresses.size() == 1);
     assertEquals( "KARINLUNDSGATAN 22 LGH 1003", address.getAddress() );
     assertEquals( "57141", address.getZipCode() );
     assertEquals( "NÄSSJÖ", address.getCity() );
   
   }
   
  
}

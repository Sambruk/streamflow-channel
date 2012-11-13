package se.streamsource.channel.qidintegration;

import java.util.StringTokenizer;

import se.streamsource.channel.transport.ContactAddressValue;
import se.streamsource.channel.transport.ContactValue;

public class ContactParser
{

   public ContactValue parse(String inputString)
   {
      ContactValue contact = new ContactValue();
      contact.setIsCompany( false );

      StringTokenizer tk = new StringTokenizer( inputString, "\n" );
      ParseContext ctx = new ParseContext( tk );
      while (tk.hasMoreTokens())
      {
         parseLine( tk.nextToken(), contact, ctx );
      }

      return contact;
   }

   private void parseLine(String nextToken, ContactValue contact, ParseContext ctx)
   {
      StringTokenizer tk = new StringTokenizer( nextToken, " " );
      String first = tk.nextToken();
      if (first.contains( "#POST" ))
      {
         return;
      }
      
      else if (first.contains("#UP")) {
         parseSecond(tk, contact, ctx);
      }
   }

   private void parseSecond(StringTokenizer tk, ContactValue contact, ParseContext ctx)
   {
      String second = tk.nextToken();
      if (second.endsWith( "12" )) {
         parseFirstNames(tk, contact);
      } else if (second.endsWith( "14" )) {
         parseLastName(tk, contact);
      } else if (second.equals( "PERSONID" )) {
         parseContactId(tk, contact);
      } else if (second.endsWith( "33" )) {
         parseAddress(tk, contact, ctx);
      }
   }

   private void parseAddress(StringTokenizer tk, ContactValue contact, ParseContext ctx)
   {
      ContactAddressValue av = new ContactAddressValue();
      String address = remainingString( tk );
      av.setAddress( address );
      String zip = parseNextValue(ctx);
      av.setZipCode( zip );
      String city = parseNextValue( ctx );
      av.setCity( city );
      
      contact.addAddress(av);
      
   }

  

   private String parseNextValue(ParseContext ctx)
   {
      String returnValue = null;
      StringTokenizer tk = new StringTokenizer( ctx.nextLine(), " " );
      tk.nextToken();
      tk.nextToken();
      return remainingString(tk);
      
      
   }

   private String remainingString(StringTokenizer tk)
   {
      StringBuffer buffer = new StringBuffer();
      while (tk.hasMoreTokens()) {
         buffer.append( tk.nextToken() );
         buffer.append( " " );
      }
      return buffer.toString().trim();
   }

   private void parseContactId(StringTokenizer tk, ContactValue contact)
   {
      String contactId = tk.nextToken();
      contact.setContactId( contactId );
      
   }

   private void parseLastName(StringTokenizer tk, ContactValue contact)
   {
     String lastName = tk.nextToken();
     String name = contact.getName();
     name = name + " " + lastName;
     contact.setName( name );
      
   }

   private void parseFirstNames(StringTokenizer tk, ContactValue contact)
   {
      while (tk.hasMoreTokens()) {
         String nextFirstName = tk.nextToken();
         contact.appendName(nextFirstName);
      }
      
   }

}

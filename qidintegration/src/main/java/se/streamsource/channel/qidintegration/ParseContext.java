package se.streamsource.channel.qidintegration;

import java.util.StringTokenizer;

public class ParseContext
{

   StringTokenizer tk; 
   ParseContext(StringTokenizer tk) {
      this.tk = tk;
   }
   public String nextLine() {
      return tk.nextToken();
   }
}

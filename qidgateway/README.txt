Qid Gateway

This is a simple mule application for Qid integration. 
It accepts HTTP get requests and responds with a JSON object with information 
retrieved from QID.


+--------------------------+
| Building the application |
+--------------------------+
You can build the example by simply running "mvn".  This will compile 
the classes, produce an application zip file and copy it to 
$MULE_HOME/apps.

Run the mule server. 

+--------------------+
| Supported features | 
+--------------------+
The mule configuration contains two outbound endpoints for the actual Qid service.
One is the test qid simulator.

To try the Qid gateway using the qid simulator run both applications and point 
a browser to: 
http://localhost:8888/?contactId=7304250165


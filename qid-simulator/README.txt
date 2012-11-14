Qid Simulator

This is a simple mule application for testing Qid integration. It simply serves information based on queries.


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
Statically served content representing one person and its data.
Look in src/main/resources for the supported persons.

http://localhost:8082/qid-simulator?contactId=7204041458

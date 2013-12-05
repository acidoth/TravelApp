TravelApp
=========

This derictory contains two travel applications for both SOAP and Thrift. 

Guidelines to use: 

1. Build both applications using maven.

2. Copy constants, src folder located in TravelApplication/temp into target folder. 

3. Modify constants file with system ip, and coordinator ip.( Its recommended to keep the ports unchanged and make sure the ports are not used by other applications)

4. Run built outcome travel-jar-with-dependencies.jar with two parameters. First one contains the time duration to run the travel application continiously and second one as the instance number(some random number but unique for each instances). 

For example : java -jar travel-jar-with-dependencies.jart 1 1 


IMPORTANT : Before starting travel application instances, make sure coordinator and participant instances are running in correct ports and ip addresses. 

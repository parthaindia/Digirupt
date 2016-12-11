Download the war file
go to apache-tomcat-8.5.8  paste the war in webapps folder
go to bin folder startup.bat

try the below url  

http://localhost:8080/AR-backend/index.html

This will give you Hello World!

Tom is up and running if we get this message
Switch on the mongod.exe and mongo.exe , with the default port , in case to change the port change the port in the Constant file in java code as well
--------------------------------------------------------------------

Create item
http://localhost:8080/AR-Digirupt/CreateItem?name=Colgate&price=20&category=basic

 name
 price
 category

3 parameters have to given with request call

It would return a item Id

----------------------------------------------------------------------
Get saved item by id

http://localhost:8080/AR-Digirupt/GetItem?id=584292893f7abc0d4b027ba3

id 



1 paramter which the id returned while you save the item




http://localhost:8080/AR-Digirupt/GetItem?id=584292893f7abc0d4b027ba3&custom=name,quanity

set custom=The parameter which you want


----------------------------------------------------------------------
Get all saved items

http://localhost:8080/AR-Digirupt/GetAllItems

http://localhost:8080/AR-Digirupt/GetAllItems&custom=name,quanity
set custom=The parameter which you want

----------------------------------------------------------------------
to generate bill

http://localhost:8080/AR-Digirupt/GenerateBill?5841c3c5da9c37c320d4fac31&5841c3c5da9c37c320d4fac=1

send id as key quanity as value 

5841c3c5da9c37c320d4fac3=1&5841c3c5da9c37c320d4fac=2

json must have a map with key being the item id and value being the number of items 


json
category

2 parameters to be given


------------------------------------------------------------------------
to get based on the bill id

http://localhost:8080/AR-Digirupt/GetBill?id=

id
1 parameter to be given

http://localhost:8080/AR-Digirupt/GetBill?id=454&custom=name,quanity
set custom=The parameter which you want
------------------------------------------------------------------------

to get all bill ids
http://localhost:8080/AR-Digirupt/GetAllBill


------------------------------------------------------------------------

   

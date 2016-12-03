# Digirupt


Download the war file
go to apache-tomcat-8.5.8  paste the war in webapps folder
go to bin folder startup.bat

try the below url  

http://localhost:8080/AR-backend/index.html

This will give you Hello World!

Tom is up and running if we get this message
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

----------------------------------------------------------------------
Get all saved items

http://localhost:8080/AR-Digirupt/GetAllItems


----------------------------------------------------------------------
to generate bill

http://localhost:8080/AR-Digirupt/GenerateBill?json= ?category=basic

{"5841c3c5da9c37c320d4fac3":"1"
"5841c3c5da9c37c320d4fac":"2"}

json example

json
category

2 parameters to be given


------------------------------------------------------------------------
to get based on the bill id

http://localhost:8080/AR-Digirupt/GetBill?id=

id
1 parameter to be given

------------------------------------------------------------------------

to get all bill ids
http://localhost:8080/AR-Digirupt/GetAllBill


------------------------------------------------------------------------

   

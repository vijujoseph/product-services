# Product Aggregator Service

### Requirement
two separate microservices serving this purpose:
-   one to read products data from a CSV file (Importer) and wrap them into a JSON
object for the other service to consume ;
-   the second to save and maintain the product data received and provide some
statistics about them (Aggregator) .

-   The first service (the Importer ) would be a simple stateless service that reads a CSV
file containing all the data regarding products and sends them as messages on a
message broker of your choice or using restful calls.
-   The second service (the Aggregator ) will handle incoming product messages to
create a new product if it doesn’t exist in its database, and update it if it was already
there.

## Note
-   Completed cration of both micro services for importing and aggregating
-   Coding is in progress for adding message broker to pass data from importer
service to aggregator services. It will be submitted by today EOD.

## Solution
-   First microservices (product-importer-service) parse the excel for data.
You can add more test data by running the test case -ProductImporterServiceApplicationTests
Before executing the test case, add the the respective CSV file under resources/template/dataExample1.csv
Then execute the data
    * At the time of starting up the application, system default load 1000 products from
    the CSV dataExample.csv.
    
-   Second microservices (product-aggregator-service) aggregate the incoming
products and save to in memory H2-DB. The micro services have different API
as below:
*   http://localhost:8080/products (POST) - to save products
*   http://localhost:8080/products/ (GET) - Providing an endpoint to list all available products in its database.
*   http://localhost:8080/products/statistics (GET) - Providing an endpoint to show daily statistics of how many products were
                                            created and how many updated. Default takes current month as return statistics
*   http://localhost:8080/products/statistics/{data} (GET) - Providing an endpoint to list 
all available products in its database. Return the stats for the given date.

## Build and Execute
```
mvn clean install
mvn spring-boot:run 
```
or
```
mvn clean install spring-boot:run
```

## Build and Execute using Intellij
### Pre-requisite:

JDK 1.8 To check, run java -version:
```
 $ java -version
 java version "1.8.0_121"
``` 
Any IDE, preferably Intellij

### Installation and Setup:

-   Go to the github url - https://github.com/vijujoseph/product-services.git
-   select 'Clone or download', copy the URL
-   Open intelliJ - File -> New -> Project From Version Control -> git
-   Enter URL - which was cloned in step 2 and click clone button
-   Select Clean and Install from Maven Project - LifeCycle
-   Run Application


## Guidance - Api Specification:
```
http://localhost:8080/products   
Request type - POST
Request body 
============
[
  {
    "uuid": "fccc13f1-f337-480b-9305-a5bb56bcaa11",
    "name": "Samsung Galaxy TEST",
    "description": "smart phone",
    "provider": "Samsung Galaxy",
    "available": "true",
    "measurementUnit": "PC",
    "createdUser": "ADMIN"
  },
  {
    "uuid": "fccc13f1-f337-480b-9305-a5bb56bcaa22",
    "name": "Samsung Galaxy Mobile2",
    "description": "smart phone2",
    "provider": "Samsung Galaxy2",
    "available": "true",
    "measurementUnit": "PC2",
    "createdUser": "ADMIN2"
  }
]

http://localhost:8080/products/statistics
Request type - GET

http://localhost:8080/products/statistics/{date} [date format - ddMMyyyy e.g) 30092019
Request type - GET
``` 
Use chrome or any rest clients for REST request and response

**Few Examples are below:**  
1. http://localhost:8080/products/statistics/30092019 - GET
    ```
    {
    "totalCreated": 5,
    "totalUpdated": 1,
    "message": null
    }
    ```
2. http://localhost:8080/products/statistics/ - GET
    ```
    {
    "totalCreated": 5,
    "totalUpdated": 1,
    "message": null
    }
    ```
3. http://localhost:8080/products/statistics/fdsf - GET
   ```
   {
   "totalCreated": 0,
   "totalUpdated": 0,
   "message": "Invalid Date Format : fdsf. Please Enter Valid Format [ddMMyyyy] e.g) 24092019"
   }
    ```
4.  http://localhost:8080/products - POST
      ```
      ============ Request Body=============
    [
      {
        "uuid": "fccc13f1-f337-480b-9305-a5bb56bcaa11",
        "name": "Samsung Galaxy 1",
        "description": "smart phone",
        "provider": "Samsung Galaxy",
        "available": "true",
        "measurementUnit": "PC",
        "createdUser": "ADMIN"
      },
      {
        "uuid": "fccc13f1-f337-480b-9305-a5bb56bcaa22",
        "name": "Samsung Galaxy Mobile2",
        "description": "smart phone2",
        "provider": "Samsung Galaxy2",
        "available": "true",
        "measurementUnit": "PC2",
        "createdUser": "ADMIN2"
      },
      {
        "uuid": "fccc13f1-f337-480b-9305-a5bb56bcaa23",
        "name": "Samsung Galaxy Mobile3",
        "description": "smart phone3",
        "provider": "Samsung Galaxy3",
        "available": "true",
        "measurementUnit": "PC3",
        "createdUser": "ADMIN3"
      },
      {
        "uuid": "fccc13f1-f337-480b-9305-a5bb56bcaa14",
        "name": "Samsung Galaxy Mobile1",
        "description": "smart phone",
        "provider": "Samsung Galaxy",
        "available": "true",
        "measurementUnit": "PC",
        "createdUser": "ADMIN"
      },
      {
        "uuid": "fccc13f1-f337-480b-9305-a5bb56bcaa25",
        "name": "Samsung Galaxy Mobile2",
        "description": "smart phone2",
        "provider": "Samsung Galaxy2",
        "available": "true",
        "measurementUnit": "PC2",
        "createdUser": "ADMIN2"
      },
      {
        "uuid": "fccc13f1-f337-480b-9305-a5bb56bcaa25",
        "name": "Samsung Galaxy Mobile22",
        "description": "smart phone2",
        "provider": "Samsung Galaxy2",
        "available": "true",
        "measurementUnit": "PC2",
        "createdUser": "ADMIN2"
      },
      {
        "uuid": "fccc13f1-f337-480b-9305-a5bb56bcaa26",
        "name": "Samsung Galaxy Mobile33",
        "description": "smart phone2",
        "provider": "Samsung Galaxy2",
        "available": "true",
        "measurementUnit": "PC2",
        "createdUser": "ADMIN2"
      }
    ]
    ``` 
    
    
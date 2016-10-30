# ElasticSearch

The project is built with client-server architecture and discusses indexing data and searching on it.
Server takes json as input and stores the data into an elastic search server. Client can query the server with a search text using the REST API [in JSON format]. 
When the server receives the request, it queries the elastic search server and responds back with the data to the client using REST [in JSON format]. 
After client receives the response, it displays the output to the user.

## Technologies and Framework used:
Java 8
Spring boot
Elastic search
JSON
HTML (Client)
JQuery (Client)
Tomcat
Maven

## Testing frameworks used
Spring boot test
Junit 4
Mockito

## How to run the project:
### Prerequisites:
Java 8 and Maven installed

### Steps to run the project:
1. Download and unzip the project folder.
2. Open the command prompt and execute the maven command “mvn clean package” or “mvn clean package -Dmaven.test.skip=true”.
3. On execution of the above command, maven builds the jar file and stores it in the target folder.
4. Jar file can be executed using the below command [Please type the below command, as sometimes copy-paste of the below command does not work due to byte difference].
   java –jar target/indexer.jar –input sample.json

5.	The above command starts the Tomcat server in the port ‘8080’ with embedded elastic search server and will be ready to handle REST requests.
6.	Double click on the index.html that opens on the browser. Enter the text to be searched and click on the search button. 
    For the first time, it takes few seconds as the server processes the REST request as well as parses the sample.json data and storing it in the elastic search server. 
    Subsequent searches will be faster as the server does not perform the operation of parsing the sample.json file.
7.	Search criteria: Search text provided in the text box searches the text in the ‘text’ field and ‘sender’ field of the emails and it can be extended to other fields as well.


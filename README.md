# ElasticSearch
Elasticsearch example with spring-boot to index and search a text


## Technologies used

1. Spring Boot
2. ElasticSearch
3. Java
4. REST

## How to run the application
1. Clone the project.
2. Import the project to your IDE
3. Download elastic search zip file from https://www.elastic.co/downloads
4. Unzip the folder.
5. Get into the bin folder and run the elasticsearch.bat file (If windows)
6. Run the main application (Application.java) with the json file name as argument in your IDE.
[Sample file name is provided in the project: sample.json]


## How does it work

When you add the filename as a argument to run the program, the json file would be converted into a elasticsearch document and 
stored in elasticsearch server (that is running). The search can be done from the browser as the application provides a REST interface.
Example: localhost:8080/email/text?text=abc

The above example gives the json output of the object that matches the string ("abc" in above case).

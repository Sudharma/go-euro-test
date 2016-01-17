# go-euro-test
The project is divided into 2 parts

1. A Query API , which under the hood knows which endpoint to be queried. in this case it is the city endpoint. QueryAPI is abstract in nature which knows only the endpoint and transforms the query parameter. Spring RestTemplate is used to handle the rest end point and the response is taken into the domain model "City" and "GeoPosition"

2. After the response is retrieved from the QueryAPI. The Response with domain model is transformed to CSV specific domain model since the domain model has nested json properties which are converted to flat hierarchy with CSV model. Java-8 map feature is used here to convert the models. Jackson data mapper APIs are used to convert json array to csv. nio.files API are used to write the stream to file and save to /$HOME/input.csv.
		For invalid inputs or no inputs appropirate messages are displayed.

#build
 1. maven is supported.
 2. for any changes, rebuild with mvn clean package.

#run
 1. java -jar target/GoEuroTest.jar --h or -help for help
 1. java -jar target/GoEuroTest.jar "CITY_NAME"
 
 

#library used
 1. java 8
 2. spring boot for consuming Rest services
 3. jackson api for data mapper and convert to csv.
 4. slf4j-api with slf4j with logback is used for logging to console.
 


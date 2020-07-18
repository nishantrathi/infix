# infix

# What did I modify?
1. Handled white spaces
2. Added a method to calculate factorial
3. How to handle calculate factorial for negative number
4. Converted this project in Spring Boot project to create rest endpoint

# How to run?
1. Open this project in your IDE (select pom.xml from directory to open this project)
2. Do mvn clean install to build the project
    - It requires Java 10 to build the project 
3. Run ExpressionApplication class to start the Spring Boot project
    - You should see this message **Started ExpressionApplication in __ seconds**
    
# How to use rest endpoint?
To send Http (GET) request, you can use Postman or Curl command.
1. Rest endpoint
    - http://localhost:8080/expressionparser/expression  
        - http - protocol
        - localhost - host name
        - 8080 - port number
        - expressionparser - project name 
        - expression - resource
    - you need to send expression in request body
2. Curl command example
    - curl -X GET -H "Content-Type: text/plain" --data '1+2+3' http://localhost:8080/expressionparser/expression
    - curl -X GET -H "Content-Type: text/plain" --data '(-1  + 2*3!)' http://localhost:8080/expressionparser/expression
    - curl -X GET -H "Content-Type: text/plain" --data '-3!' http://localhost:8080/expressionparser/expression
3. Postman
    - Select GET request
    - Paste this url http://localhost:8080/expressionparser/expression in url section
    - Paste your expression in body section
    - Hit the send button
4. Response from endpoint 
    - 200 - Status OK (Expression output)
    - 400 - Bad Request (Example - 2*3aaaa)
    - 404 - Not found (Failed to calculate the expression)
    - 500 - Internal Server Error 
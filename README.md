# currency-collector
This API for the collection and search of official exchange rates of the Azerbaijani manat against foreign currencies. 

# Steps to run
1.Clone the repo
  ```sh
  git clone  https://github.com/janamazov/currency-collector.git 
 ```
2.After installation just open the project folder via terminal run
 ```sh
  docker-compose up 
 ```
Then run application<br>
Application runs on port 8082 port

# Default static token
x-authorization-token<br>
rFcOirGU3v9n4643q4Xu952qyA5JZtZsR8ybPj6zuA

# Default user for Basic Auth
username: admin<br>
password: 12345


# Authenticated users via Basic Auth can:
*Get Rates against AZN for specific Date and Currency<br>
*List Rates against AZN for specific Currency<br>
*List Rates against AZN for specific Date<br>

# Another APIs requires only static token 


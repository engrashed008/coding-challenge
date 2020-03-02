
<p align="center">
  <img src="https://globalline.my/static/logo.png" width="200">
</p>


Thanks for providing me the opportunity to participate Coding chanllege of GLN. 

# Overview:
This sample project is developed based on spring boot webapi tool/technology. 

## Prerequisites
 1. Intellij Idea
 2. Java 1.8 or more
 3. maven(Integrated with Intellij)
 4. Postgresql (Please have a look the application.properties file for more details.)
 5. Api test tool. ( i.e postman) 

## Architecture
Spring boot with myBatis mapper is implemented in this sample project. 
Please have a look sample : https://www.bswen.com/2018/04/springboot-springboot-and-mybatis-and-mysql-with-mapper-xml.html

WorkFlow :  controller -> service -> Dto -> Mapper Interface -> xml Mapper -> Fetch result from DB.

## Configuration
1. Please install Intellij
2. Import as maven project
3. Please install postgresql
4. Please use API testing tool.

Alternative Approach : If DB is not functioning well, please enable  DataSourceAutoConfiguration.class.
@SpringBootApplication(exclude={SecurityAutoConfiguration.class /*,DataSourceAutoConfiguration.class*/ })

Then please comment all mapper interfaces and xml mappers. Test data is written in the service class so output can be displayed.
PageHelper is integrated with mybatis. So, sample output could not work with pagination.

## Questions
For any kind of queries please feel free to share me. 

## Not Completed
Sorry, test cases are not written due to time constraints.


Hope sample project may satisfy the reviewers 
Thanks !




  

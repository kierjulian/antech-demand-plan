#ANTECH DEMAND PLAN OPTIMIZATION PROJECT

#Description
This project was created to optimize the creation of ANTECH's Demand Plan.

#Prerequisites for running the project locally
1. Java 8
2. Maven
3. MySQL 8

#Steps for running the project locally
1. Make sure the database is set up properly. The SQL file can be found in the sql folder.
2. The url, username, and password could be found in the application.properties.
3. Run `mvn clean spring-boot run` from the root directory to run the project.
4. Verify by visiting `localhost:8080`.
5. The credentials are hard-coded and loaded via memory. It can be found in the `WebSecurityConfig.java` file.

#AWS keys
The AWS test-server keys can be found in the `keys` directory. 
The directory also contains the SSL certificates for the test server. The SSL certificates were generated using `gethttpsforfree.com`.

#Project Documentation
The project documents are generated via maven.
 
For generating a standalone documentation, run `mvn clean javadoc:javadoc`, the documents generated is located at `/project-root/target/site/apidocs`. 
For generating a site documentation, run `mvn clean site`, the documents generated is located at `/project-root/target/site`.

#Contact
For contacting the original developer of this project, please free to send me an email at `kmgenoguin@up.edu.ph`. Cheers!


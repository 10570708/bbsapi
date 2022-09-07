# bbsapi

# Bigbookswap API

# About

This is a SpringBoot Kotlin REST API Application written to work with a Single Page Application as part of the development of an MVP prototype for an application called
'The Big Book Swap'. It is a final year project entry for Lisa Daly ( 10570708 ) for DBS 2022 Final Project B8IT131_2122_TME2

## To Run the entire application locally :

# Start the REST Application 

1. Download the Application
2. Open the Application in IntelliJ
3. Change the filepath for the local database file in src/main/resources/application.yaml (change **~\dbs\api\db** on line 10 to suit where you want the database file to be created)
3. Run the BigbookApplication.kt SpringBoot Application file

This will start the BBS REST Application on http://localhost:8080 and create and seed the database.

# Start the Angular Application 

The BBS Angular FE application must also be running on http://localhost:4200 for the entire application to be tested.

Default users with books and swaps will be created - with  
1. username: user1 and password: pass1 
2. username: user2 and password: pass2
3. username: user3 and password: pass3


# Webflux-Mongo-Server-application

This is the Server Side Application for Spring Webflux Reactive Programming
Which is using the Mongo DB for storing the Data

To start the Mongo DB:
install Mongo DB locally.

set the path for local machine: export PATH=/Users/preddy/Documents/mongodb-macos-x86_64-4.2.3/bin:$PATH;

Create the directory in local to store the DB Data:
 Mkdir <Directory-path>
 
 Start the Mongo DB before running the application:
 mongod --dbpath <path to data directory>
 
 #Used CommandLine Runner to store the data in MOngo DB while starting the application.
 
 # Used Routers and Handler functions as well to stream the data and to achieve the Reactive Programming.

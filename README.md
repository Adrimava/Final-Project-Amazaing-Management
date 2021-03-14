# Amaza-ing Management

is a resource management game developed in one week as a final project for Ironhack by Adrián Maza Vázquez.

It uses Java Spring-boot and SQL as backend and Angular as frontend.

## how to initialize the application:
Before starting you must be able to run on your computer the command mvn spring-boot:run and be able to handle SQL scripts.

The first thing to do is to run the SQL script located in the ./data base folder. During the development of this project MySQL Workbench has been used.

Then you have to access the folders containing the Eureka server and the rest of the services, located in ./backend. The command "mvn spring-boot:run" must be executed in each of them
(eureka-server, player-service, employee-service, company-service, business-model-service and amazaing-management-edge-service).

Finally, access the folder ./Amazaing-Management-frontend, where everything related to Angular is located, and execute the command "ng serve".

The application is divided into microservices and works by calling the amazaing-management-edge-service service and two APIs from the front end. amazaing-management-edge-service connects in turn with the rest of the services, from which it obtains the necessary data.

Once all these steps have been completed, the application can be accessed at the following url: http://localhost:4200/

## What can be done in the application?

The objective of the game is to accumulate as many companies and money as possible. Although in this first version the functionalities are somewhat limited, 
you can create different players that will serve as avatar, for which you have to open the drop-down menu below the name of the current player and select the option create/delete.

Each player will be able to buy and sell different companies, hire and fire employees and relocate them to the most convenient place.
Each company will generate different profits and each employee will have a different productivity level generated randomly. Employees also have a percentage of clumsiness, 
which will allow future updates of the application to trigger random events such as accidents that can cost money to repair.

## What's coming in the future?

-Random events based on employee clumsiness.
Possibility of real-time management (information will be updated every few seconds).
-Limitations on hiring and purchasing companies.
-Possibility of borrowing from the bank.
-Possibility of contracting different insurances.
-Greater management possibilities.

## Additional details:
The avatars have been obtained through connection with the API https://avatars.dicebear.com/.
Names are randomly generated with API https://randomuser.me/api/.

Thank you for testing the application. Enjoy it!

# Dog Ate My Homework

<img src="https://cdn.discordapp.com/attachments/1023979792401453148/1055204119075364864/MY_DOG_ATE_MY_HW_COVER_IMAGE.png" alt="The Dog Age My Homework Homescreen" title="Dog Ate My Homework">

*This is a repository for a group project for CSC207: Software Design at the University of Toronto.*

Dog Ate My Homework (DAMH) is a task manager with a twist. You begin by choosing a pet, who accompanies you as you accomplish various tasks. Win points to customize your pet, but be careful! If you miss a task deadline your pet will be damaged, requiring you to heal your pet. Miss too many tasks and your pet will die :(

Table of Contents:
1) Features of the program
2) How to run the program
3) Design patterns and SOLID
4) Challenges and future implementations of the program
5) Testing: Coverage and future implementations

## Features

* User opens the program: Shows default interface upon first action. Checks if any deadlines have been missed in ToDoList, and deducts points
* User creates a task. Checks if there exists task with identical name in checklists
* Adds the task to ToDoList
* User adopts a pet
* User modifies a task
* User completes a task. Removes the task from ToDoList and adds to Donelist. Rewards points if the task is finished before deadline
* User buys hearts
* User buys items
* User wants to see randomly generated task from ToDoList
* Each entity and use case is in adherence to the Single responsibility principle 

## 
## How to Run

   * This program was constructed using SDK Corretto-11 or Amazon Corretto version 11.0.16. Ensure to mark the 'src' file as 'sources root' before running. After downloading the files of this repository, navigate to src/main/java/Main.java. Run this file to run the program. 
    
## Running Tests:
   * To run the tests, JUnit 5.81 is required, IDE's like IntelliJ may recommend to add this library to the gradle. Also, the package jdatepicker 1.3.4 is required for the date-parsing of the program. To view the coverage of the tests, run src/test with coverage. 
    
## Design Patterns and SOLID
1) Dependency Injection (CheckList, Task) : The toDoList forces the createtask usecase interactor to implement the dependency injection design principle. The todolist has a method that adds a task to its list, however this method will only take in an instance of an already created task, this loosens the coupling between the todolist entity and the task entity, as the todolist will never call the task’s constructor.
2) Simple Factory (RefresherFactory, PetRefresher, TaskListRefresher)
3) Singleton: UserUC
4) Facade: User entity class. In terms of single-responsibility, each class is controlled under a single User, the User is therefore the only source of change of the ToDoList, the DoneList, and its own pet, this also fits the facade design pattern as the usecase interactors only interact with the User, which interacts with all its attributes.
5) Liskov: In terms of Liskov’s Substitution principle, we made a modification to our original CRC model. The checklist was supposed to be an interface that the ToDoList and DoneList will implement but we found the that there was redundant code so we converted it to an abstract class. 
6) Open/Closed: Furthermore, the we committed to making the program more open to extension as the checklist declares its taskList as a List and and then instantiates it as an arraylist.

## Challenges and future implementations
* One challenge that we faced was that we did not know how to identify the current which is the old task at hand - we came up the idea that we will look up the old task that is to be modified with the “task name” - however, due to duplication this was an issue - further we decided that we will add an additional checker that makes sure that each task’s name is unique and that is how we were successfully able to find out a way to implement our ModifyTask use case. In a future implementation, it will be useful to change the ToDoList to a dictionary with task names as the keys and tasks as the values. 
* Some code smells of the program include long, nested if statements, where a strategy design pattern may be applied. Also, some redundant methods, such as the refresh methods in the use case interactors, may be replaced with default methods of an interface.
* Also, many of the use case interactors call on either the petRefresher or the taskRefresher. These use case interactors therefore have the same method that results in redundant code between them. In the future, it may be useful to implement a interface with a default method that calls on the pet refresher or the task refresher, then each use case interactor can implement this interface and call on that method.
* As of right now, the program lacks in terms of universal principles of design. Future implementations should make the program more adhering to the equitable use principle, perceptible information principle, and flexibility of use principle. Such additions can include different colour patterns for the pet and background, different sized fonts for the tasks and lists, and the use of text-to-speech and speech-to-text for users to interact with their To-Do list. 

## Testing: Coverage and Future implementations
* The tests file contains all of the tests for this program. In terms of coverage, each individual test file has its coverage documented, including the class it covers, the methods covered, and the lines covered. In cases where coverage is not 100% for methods or lines, the test class documentation includes a reasoning why certain methods were not tested.
* Overall: coverage of the entities, controllers, and presenters is 100% classes, 100% methods, 100% lines. Coverage for the use case interactors is 100% classes, 71% methods, and 81% lines. 
* Mainly, the refresher methods of the use case interactors were not tested as they only call on the PetRefresher or TaskRefresher class to perform the refresh. Also, the methods using the static UserUC singleton were not tested as the UserUC singleton is not declared until the Main file of the program is running. Furthermore, these methods call on the tested methods, they just use the static User as the 'user' argument. 
* Future tests should include the InvalidTaskInformation exception, as well as a few UI components. It may be helpful to create a 'fake' placement static UserUC singleton to test methods in the interactors.

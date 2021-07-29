# Wainwrights-Project
## CRUD PROJECT BACKEND 

### Contents 
1. Resources 
2. Brief 
3. Kanban Board 
4. Database Structure 
5. Data Stack 
6. Front-end 
7. Testing 
8. Stretch Goals 

### Resources 
* Presentation [link](https://qalearning-my.sharepoint.com/:p:/r/personal/epenrice_qa_com/_layouts/15/Doc.aspx?sourcedoc=%7BF988BCAB-EB25-440C-9374-5F0FB2C55469%7D&file=Presentation.pptx&wdOrigin=OFFICECOM-WEB.START.REC&ct=1627566952050&action=edit&mobileredirect=true)
* Jira Board [link](https://testjira0.atlassian.net/jira/software/projects/TP/boards/1/backlog?selectedIssue=TP-3)

### Brief 

To create a CRUD application with the utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training. 

This project will involve concepts from all core training modules; more specifically: 

* Project Management (Kanban Board + Version Control) 
* Databases 
* JAVA 
* Spring Boot 
* HTML + CSS + JAVASCRIPT 
* Back-end testing (Junit and Mockito) 

### Kanban Board 

For the Kanban board I used Jira Software and modelled it as an Agile Scrum Board by firstly creating three epics: ‘Frontend’, ‘Backend’ and ‘Database’, then stated all of my user stories in the ‘as a user I want to be able to... so that’ format. In these statements I have tried to think about user experience and functionality, as well as fundamental elements in the backend in terms of testing. Each statement is assigned story points regarding its difficulty and prioritisation, this can be seen in the Backlog on Jira.  

I then activated the epics as one sprint and throughout my project I moved each task to the appropriate place on the Kanban board.  

### Database Structure 

I created my database in MySQL Workbench and linked it to my backend in Java so that I could easily use CRUD functionality without having to change my code or physically add/remove elements in Workbench. 

### Data Stack 
#### Database 
Two databases have been used for this project. A local H2 Console with a wainwright-data.sql and a wainwright-schema.sql that have been saved in the back end to auto populate the fields to extend. Using a local database, this provides a convenient and fast approach to testing the back end. A MYSQL database has been used for production purposes. 
#### Backend 
The back end is powered by Java using the Spring Boot Framework. This allows rapid and simple deployment of an integration structure between the database and the front-end. The back-end has the DB logic as well as the HTTP requests and allows the front-end to access the DB through the use of annotations in the back end. 

#### Front-end 
The front end is powered by HTML, CSS and Javascript, . HTML and CSS have been used to produce the appearance of the website and javascript has been used to get data from the DB to populate the elements on the webpage. 

### Testing 

I was able to conduct successful testing of the backend by utilising Unit and Mockito testing before starting on my front end and linking them both. 

### Stretch Goals 
Further improvements would consist of: 
* Functionality improvement of the application by adding a ‘Completed’ element so that the user can keep a record of the Wainwrights which have been completed  
* Functionality improvement of the application by adding a related database, allowing the user to create a list of possible routes for each Wainwright. 
* Functionality to add warnings prior to the user deleting or updating records. 
* The use of Bootstrap to improve the overall appearance of my web app  

### Author and Acknowledgements
I would like to acknowledge the QA trainers, specifically Jordan Harrison and Jordan Benbelaid for providing me with the knowledge to be able to have completed this project as well as BAE12 Team 4 for making the process a lot less stressful than it may otherwise have been.

Project by Emily Penrice

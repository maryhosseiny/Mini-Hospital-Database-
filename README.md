# My Personal Project
## Project Description

This *project description* addresses the following questions:
- What will the application do?
- Who will use this application?
- Why is this project of interest to me?

My project is a hospital database application where the user can perform various tasks.
This includes features such as viewing the hospital staff names and their ids, adding or removing
a patient to the hospital database, viewing a patient's information, and viewing the patients
that are discharged from the hospital. The hospital database also includes a medication 
section, where the user can see a medication's name, serial number and brand. The user 
is also provided with the feature of adding and removing medication from the hospital
database. This application can be used by high school students in order for them to understand 
how a hospital database operates and what features it includes. This application specifically
focuses on introducing high school students to the basics of user info within the medical
field as well as some basic operations that are used on a daily basis in a hospital. This project 
is an interest mine since I've actively worked with different patient databases where I was able 
to gain more knowledge and insight as to how real life database applications operate. Hence, why I 
thought being able to recreate a smaller, more compact version of these application would
be a good idea.

## User Story

The *user stories* describe how someone can use the application to produce a 
specific outcome.
- As a user, I want to be able to add and remove a patient to a list of patients
- As a user, I want to add and remove medication from the available medication within the hospital
- As a user, I want to see a list of staff members with their names and employee IDs
- As a user, I want to see a list of all existing patients in the database
- As a user, I want to see a list of all discharged patients in the database

- As a user, I want to be able to save all my patients and medications into a file
- As a user, I want to be able to view and load the hospital database from file

## Instructions for Grader

- You can generate the first required event related to adding Xs to a Y by clicking 
the View Patient button. After which you will press the add patient button
where you are taken to a new page. In this page you will see a list of patients
as well as place to fill in to add a new patient to the system. Fill in the blanks
according to their label then press submit to add the patient to the file. You can press 
view patient button to view the changes to that you made to the database (Same steps
 apply for add medication to the medication database).
- You can generate the second required event related to removing Xs to a Y by clicking
  the View Patient button. After which you will press the remove patient button
  where you are taken to a new page. In this page you will see a list of patients
  as well as boxes to fill in to remove the patient from the database. Fill in the blanks
  according to their label then press remove button to remove the patient from the 
database (same steps apply for removing a medication from the database).
- You can locate my visual component by once you start the program, you will see
a snippet of one of my favorite memes on Twitter (titled This is fine). To see the 
full image you can enlarge the window.
- You can save the state of my application by clicking the save button
provided in modifier tabs where a change in the system occurs. You can find those
 tabs located on the left side on the sidebar.
- You can reload the state of my application by clicking the load button provided
in the main menu tab on the sidebar.

## Phase 4: Task 2
Below you will see an example of event logging in the project. After initializing the 
hospital and adding all the databases in place (this includes the addition of staff, 
medication and patients to the hospital), the event log is cleared. This is 
so that the user will have an easier time tracking the changes they have made to the 
system. Hence, the example below will first have a date along with a time followed by an
"Event log cleared." After which any changes made by the user 
to the database is logged then displayed once the program closes. This can be seen in 
the third and forth line of the example, where time and date are shown and are followed 
by the "New patient added."

### Example Event Logging: 

Fri Dec 02 19:18:56 PST 2022

Event log cleared.

Fri Dec 02 19:19:09 PST 2022

New patient added.


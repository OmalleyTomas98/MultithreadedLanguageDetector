----------------------------------------------------------------
	README FILE 
----------------------------------------------------------------

 Author    : Tomas O'Malley (G00361128)@gmit.ie
 Program   : Java Multi Threaded Language Detector
 Course    : Software Development ,Year 3, Advanced Object Orientated Programming 
 Weighting : 50% 
 Due Date  : Tuesday, 7 January 2020, 12:00 AM

Project Description: You are required to develop a Java API that can rapidly compare a query text file against a n gram collection of subject texts and determine the natural language of the query file. The API
should uphold the principles of loose-coupling and high cohesion throughout its design by
correctly applying abstraction, encapsulation, composition and inheritance. 

 +++ Features +++
	-command line interface menu 
	-Build a subject Database 
	-Query a File 
	-Output the language Detected by Program
----------------------------
Program Packaging break down 
----------------------------
Contents found in g00361128 JAVA Project 

-G00361128.zip 
Zip file holding entire Eclipse Project submitted to Moodle

-oop.jar
Jar file holds/compresses  all the contents such as classes,packages,txt files etc as one to be easily 
executed.

-design.png
A UML diagram displaying the key classes and their relationships with each other.


PACKAGE 
-------------------
package .
gmit.sw.ie 
-------------------
CLASSES
-------------------

-Database.java
Holds existing and adds new languages in the project and stores and acts as a database for languages to be detected.

-Language.java 
Holds the list of languages known to be shown to client when program has completed detection

-LanguageEntry.java
Used to hold the frequencies and compare the results to the file used by the user  

-Menu.java
Menu prompts  and allows  the user to navigate through the application eg output in program :

-Parser.java
The parser class is the brains of the application that parses the clients input and determines the language.

-Runner.java
Holds main method/start Thread to execute the Program  


********************************************
*		                           		   *
* Dept- Computer Science & Applied Physics *
*         Text Language Detector           *
*	 	                          		   *
********************************************

Options found below :
===================

1.To parse a file 
2.To Quit Program

The user is prompted with this welcoming menu and must enter a Wili to continue 
(1) here is sample output
++++++++++++++++++++++++++++++

========================================= 

Enter WILI Data Location>
wili-2018-Large-117500-Edited.txt

Enter Query File Location>
English.txt 

(txt* files)
===========
English.txt  - contains sample English file for language detection 
===========
Gaeilge.txt  - contains sample Irish  file for language detection 
============
wili-2018-Large-117500-Edited.txt -
============
wili-2018-Small-11750-Edited.txt  -
============
-README.txt :) - The file you are reading which documents and explains the fundamental/core features and obstacles found in the java project.
===========
Created in 2012

1. Name: Lin Guo 

2. ID:5735679970 

3. Username on aludra.usc.edu: guol

4. Submitted file:createdb.sql; dropdb.sql; populate.java; hw2.java;hw2.form;readme.txt 

5. How to compile populate.java: 
I put classes111.jar, sdoapi.zip, populate.java, hw2.java,hw2.form, map.jpg in the same folder, then typying the following code: 

javac -classpath .;classes111.jar;sdoapi.zip populate.java

6. How to run populate: (building.xy, people.xy, and ap.xy are also put into F disc)

java -classpath .;classes111.jar;sdoapi.zip populate building.xy people.xy ap.xy

7. How to compile hw2.java: (hw2.java and hw2.form are put into F disc)
(it will show 4 warnings, but it doesn't matter)

javac -Xlint -classpath .;classes111.jar;sdoapi.zip hw2.java
8. How to run hw2:

java -classpath .;classes111.jar;sdoapi.zip hw2

9: Additionlly instruction: 
There are three buttons:
1) Submit Query accomplished the functions like the homework description; 
2) Clear Text Area button clears the Text Area which displays the queries.
3) Clear GUI of MAP clears the graphs in the map and also the Radiobuttons and CheckBoxs 

The three checkboxs and four radiobuttons accomplished the functions like homework description. 

There is a label which shows the coordinations of the mouse. 

In my work, I used the database which called Test, the username is scott and password is 12345. 
I changed the database name to csci585, userName is temp585 and password temp585, because they are the names in the sample code. I did this for you guys compiling easily. 

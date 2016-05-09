# Text-to-XML
Small Java sample for transfering text file to xml file.

Application Implement with Plain Java.
   
   a)  Plain Java,
   
   b)  Maven Builder,
   
   c) Missing Test Specs. 
   
   
Input file:

   Policies.txt --attached in the folder.
   
output file:

   Policies.xml --attached in the folder.
   
Application Structure

src/main/java/org/kevinchen278/java/toxml/---App.java          --- application entry.
                                             XMLConvertor.java --- Main Class.
                                             MyUtil.java       --- Common Class provided all the common static functions.
                                             Policy.java       ---- not use.
                                             MockData.java     ---- empty.
pom.xml    ------   setting file, for maven.
README.md   ------  this file.
policies.txt -----  Text file with a few data for testing
policies.xml -----  generated xml file from associated text file.


   

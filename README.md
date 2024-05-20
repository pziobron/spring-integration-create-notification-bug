Steps to reproduce the issue:
1. Install Temurin JDK, version 17.0.9+9 or the latest 17.0.11+9 ( https://adoptium.net/temurin/archive/?version=17 )
2. Launch the Spring Boot Application using the Temurin JDK (version 17.0.9+9)
3. Open the shell and go to the project's directory
4. There should be test-dir folder created after application is started
5. Go to the test-dir folder
6. Execute the following command: 'mkdir b3; sleep 2; mv b3 b4; sleep 3; cp ../src/test/resources/test.jpg b4/; sleep 2;
   mkdir b5; sleep 2; mv b5 b6; sleep 3; cp ../src/test/resources/test.jpg b6/; sleep 2;
   mkdir b7; sleep 2; mv b7 b8; sleep 3; cp ../src/test/resources/test.jpg b8/; sleep 2;
   mkdir b9; sleep 2; mv b9 b10; sleep 3; cp ../src/test/resources/test.jpg b10/; sleep 2;
   mkdir b11; sleep 2; mv b11 b12; sleep 3; cp ../src/test/resources/test.jpg b12/; sleep 2; 
   sleep 4; cp ../src/test/resources/test.jpg b6; sleep 3
   sleep 4; cp ../src/test/resources/test.jpg b8; sleep 3
   sleep 4; cp ../src/test/resources/test.jpg b10; sleep 3
   sleep 4; cp ../src/test/resources/test.jpg b10/test2.jpg; sleep 3
   sleep 4; cp ../src/test/resources/test.jpg b10/test3.jpg; sleep 3
   sleep 4; cp ../src/test/resources/test.jpg b12; sleep 3'
7. Observe the logs and verify if all the subfolders are empty !



Steps to reproduce the issue:
1. Launch the Spring Boot Application
2. Open the shell and go to the projects directory
3. There should be test-dir folder created after application is started
4. Go to the test-dir folder
5. Execute the following command: 'mkdir b3; sleep 2; mv b3 b4; sleep 3; cp ../src/test/resources/test.jpg b4/; sleep 2;
   mkdir b5; sleep 2; mv b5 b6; sleep 3; cp ../src/test/resources/test.jpg b6/; sleep 2;
   mkdir b7; sleep 2; mv b7 b8; sleep 3; cp ../src/test/resources/test.jpg b8/; sleep 2;'
6. Observe the logs and make and verify if all the subfolders are empty !



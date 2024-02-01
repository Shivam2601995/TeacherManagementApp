Introduction: 
1. This is Teacher Management CLI Based Java Application which uses File System for Data Storage.
2. Application provides different features like show, add, delete, filter, search, and sort.
3. It also validates the user inputs on console.
4. Integrates with docker, the docker image(086shivam/teachermanagement) is available(deployed) on public registry called docker hub

How to run the Application?
1. All you need have only docker installed on your machine.
2. Run the following commands on CMD:   
         (I). docker pull 086shivam/teachermanagement
          (ii). docker run -it 086shivam/teachermanagement
 

WHY I used docker?
This project depends on two dependencies one is “java(JRE)” and file system for data storage.
1. we can run this project without having java installed on any machine.
2. And if you are running this Application first time by pulling image from docker hub, then you will have already some teacher’s records in File System so you can directly perform the operations.

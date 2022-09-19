Company - Volante Technologies, Pune

# Camel-Integration-for-Queue-Communication
A queue is used as medium to comunicate between two devices

As all of you know what is Queue?

Queue is nothing but a data structure which is used to hold messages in a tunnel and send it one by one. It is FIFO(First In First Out), take an example of railway station where passendgers are standing in line to take the platform ticket one by one.

A queue is one the best way for communication between two systems because if one systems is down for some period then it stores the request within it and send a tranmission to check whether the system is up or not. If system is up then the queue will send the response to other system. In this way there is no chance of communication or information lost.
A queue has several advantages in number of fields such as Aviation, Banking, Stock Market etc.

What i have encountered in real situiation is to build a queue can be handy as well as difficult to integrate and communicate with applications.
Let me tell you a story why i have written this article is because i was working on a project where, Everyday our application generates a file with the bank data and sends to the bank about the information of transactions contain in it via Email. One day our system got full (i.e disk drive) where files are created and send via email one by one to banks the deletes the files afterwards. so in this case for that day some files were send to the banks and some files were not send, so we have to manually take out the file from the location check the data with the database and send that files to banks manually so it has taken a lot of manual work. In this case i though to use the queue for communication. 

There are lots of queues avaliable in market but most people dont know how to connect the queues with their application. Ex:- RabbitMQ, IBM Queue etc
For this pratical purpose i will use the apache activemq community version where i will send a message to queue from application and receive the response. It works on the producers and consumers problems where producers is used for sending the request to queue and queue will send the response to consumer who is consuming.
This is the integration done in Apache Camel Framework, where it has simplified the communication between two systems in a linear way. You just need to define the queue name to where the request is send(i.e tag to() for producers) and to queue name from where we have receive the request(i.e tag from() for consumers)

A simple Queue implemenatation program in c to understand how a queue works is attached and also the camel integration for queue implementation.

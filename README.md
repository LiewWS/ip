# Duke User Guide

This is an edited project template for a greenfield Java project.
It's named after the Java mascot _Duke_.

This program provides a list to keep track of tasks.
Given below are instructions on how to use it.

## Getting Started
Ensure that you have Java 11 installed. In particular, the JVM needs to be installed.

Download the JAR file from the "Releases" tab in the right sidebar.
Avoid having a folder named "DukeData" in the directory that contains the JAR file,
otherwise your data could be lost.

## Usage
From the command line, run the following command to start the program:
```
java -jar ip.jar
```

The program implements the following operations:
* Adding tasks to the list.
* Listing the tasks currently in the list.
* Marking a task in the list as completed.
* Deleting a task from the list.
* Searching the list for tasks by keyword.

Supply the following command to exit the program:
```
bye
```

### Adding a task to the list
This program recognizes three types of tasks: to-dos, deadlines and events.
By default, a task is marked as incomplete upon addition.

##### To-dos
To-dos are the simplest tasks that can be added to the list.

Adding a to-do to the list can be done with the following command:
```
todo <name of todo>
```
Replace `<name of todo>` with the name of the task that you would like to record in the list.
For example:
```
todo stuff
```
Gives the output:
```
 Task added: 
 [ToDo][N] stuff 
 This list has 1 task.
```

##### Deadlines
Deadlines have an additional field to indicate the time before which
the task must be completed.

Adding a deadline to the list can be done with the following command:
```
deadline <name of deadline> /by <time>
```
Replace `<name of deadline>` with the name of the task that you would like to record in the list.
Replace `<time>` with the time before which the task must be completed.
For example:
```
deadline work /by later
```
Gives the output:
```
 Task added: 
 [Deadline][N] work ( by: later )
 This list has 2 tasks.
```

##### Events
Events have a field to indicate the time before that the event will occur.

Adding an event to the list can be done with the following command:
```
event <name of event> /at <time>
```
Replace `<name of event>` with the name of the task that you would like to record in the list.
Replace `<time>` with the time at which the event will occur.
For example:
```
event lunch /at 1am
```
Gives the output:
```
 Task added: 
 [Event][N] lunch ( at: 1am )
 This list has 3 tasks.
```

### Listing the tasks currently in the list
This operation prints the details of all the tasks stored in the list
at the time when the command is supplied.

This is done with the following command:
```
list
```
Which gives the output:
```
 The following items are tracked:
 1. [ToDo][N] stuff 
 2. [Deadline][N] work ( by: later )
 3. [Event][N] lunch ( at: 1am )
```

### Marking a task in the list as completed
This operation marks the task at the specified serial number as completed.
The serial number is the number displayed to the left of the task when it is listed
with the `list` command.

This is done with the following command:
```
done <serial number>
```
where `<serial number>` is the serial number of the task to be deleted.
For example:
```
done 1
```
on the list
```
 The following items are tracked:
 1. [ToDo][N] stuff 
 2. [Deadline][N] work ( by: later )
 3. [Event][N] lunch ( at: 1am )
```
gives the output:
```
 Nice! You have completed the following item: 
   [ToDo][Y] stuff 
```

### Deleting a task from the list
This operation deletes the task at a specified serial number in the list.
The serial number is the number displayed to the left of the task when it is listed
with the `list` command.

This is done with the following command:
```
delete <serial number>
```
where `<serial number>` is the serial number of the task to be deleted.
For example:
```
delete 1
```
on the list
```
 The following items are tracked:
 1. [ToDo][Y] stuff 
 2. [Deadline][N] work ( by: later )
 3. [Event][N] lunch ( at: 1am )
```
gives the output:
```
 Task removed:
 [ToDo][Y] stuff 
 This list has 2 tasks.
```

### Searching the list for tasks by keyword
This operation displays all the tasks in the list that contain the specified keyword.

This is done with the following command:
```
find <keyword>
```
where `<keyword>` is the keyword to search for.
For example:
```
find lunch
```
on the list
```
 The following items are tracked:
 1. [Deadline][N] work ( by: later )
 2. [Event][N] lunch ( at: 1am )
```
gives the output:
```
 Found the following tasks in the list:
 [Event][N] lunch ( at: 1am )
```

### Saving and loading data
The data for the tasks in the list are automatically saved on exit.
The data is also loaded automatically when the program starts.

## Summary of Commands
Add a to-do to the list:
```
todo <name of todo>
```

Add a deadline to list:
```
deadline <name of deadline> /by <time>
```

Add an event to the list:
```
event <name of event> /at <time>
```

Listing the tasks in the list:
```
list
```

Marking a task in the list as completed:
```
done <serial number>
```

Deleting a task from the list:
```
delete <serial number>
```

Searching the list for the tasks by keyword:
```
find <keyword>
```

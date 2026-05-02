COS 161 – Project 3: To-Do List System

How to Compile and Run:

Prerequisites:
Eclipse IDE or any Java-compatible IDE

Compile and Run:
Open your terminal or command prompt, navigate to the todolist directory and run:

How the System Works:
The To-Do List System is a command line application that allows users to
	create, manage, and organize different types of tasks.

Task Types:
Simple Task - a basic task with a title, description, and due date
Priority Task - a task with a priority level between 1 and 5
Recurring Task - a task that repeats on a daily, weekly, monthly, or yearly schedule

Features:
1. Add Task - create a simple, priority, or recurring task
2. View All Tasks - display all tasks with their index
3. Complete Task - mark a task as complete
4. Remove Task - delete a task from the list
5. Undo Last Action - reverse the most recent add, remove, or complete
6. Load Today's Tasks - load all recurring tasks into the queue
7. View Task Queue - display all tasks currently in the queue
8. Process Next Task - remove the next task from the queue and optionally mark complete
9. Filter Tasks - filter by completion status, task type, or priority level
10. Exit - close the program

Design:
We used two separate undo stacks (one for actions, one for tasks) instead
  of one stack storing Objects, to avoid casting and keep the code simple.
Tasks are displayed starting at index 1 for user readability, but stored
  internally at 0-based index.
The queue only holds RecurringTask objects.
Input validation is handled throughout using try/catch blocks to prevent
  crashes on invalid input.

Authors:
Devin O'Brien
Dax Morin
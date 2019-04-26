# CS 3308 Mission 01

## Due: Friday January 18, 2019 @ 2300

## Purpose
* To explore the implementation and use of a Singly Linked List
* To put into practice the principle of Program by Contract
* Learn to use provided code documentation to implement a given component
* To begin TDD

## Problem Statement
We need to design a scoreboard to store highschores for a video game. You are given the classes which represent a score, called `GameEntry`, and the `Scoreboard`. Each game entry simply contains the score associated with a player's name. The scoreboard maintains a list of scores which has a maximum capacity that can be saved. It is your job to implement the underlying data struture which will be used to sotre each score. In this case we will be implementing a singly linked list to store the socres. This list will need to implement, and conform to, a provided interface called `List`. The capacity constraint will be a part of the `Scoreboard` class and will be handled within that class' methods.

To get you started this project contains sources folders with two packages: `edu.isu.cs.cs3308.structures` and `edu.isu.cs.cs3308.structures.impl`. The former package is the location of the interface `List` and the latter is the location for the implementation `SinglyLinkedList`. Outside of these packages are three other files:

* `Driver.java` which contains the executable `main` method for the program
* `GameEntry.java` which contains the `GameEntry` classes, and
* `Scoreboard.java` which contains the `Scoreboard` class.

I leave the complement implementation of the `SinglyLinkedList` class up to you.

Each component of the assignment is associated with a unit test found in the testing packages. You should review these tests prior to commencing development. During development you should routinely execute these tests to evaluate your own progress. You can evaluate these tests as follows at the command line (from within the project directory where the `build.gradle` file resides):

* On windows: `> gradlew test`
* On Mac/Linux: `> gradle test`

You can also simply "Run All Tests" from your IDE as well. In either case you will see which pass and which do not.

## Assignment

1. Fork this repository
2. Build a generic Singly Linked List class which implements the `List<E>` interface, found in package `edu.isu.cs.cs3308.structures`, in a class called `SinglyLinkedList<E>` in the package named `edu.isu.cs.cs3308.structures.impl`.
3. In the `Scoreboard` class there are two methods: `add(GameEntry)` and `remove(int)` which are also required to be implmeented.
4. Associated with each class are a set of unit tests. You should execute the unit tests for each component in order to ensure that you have correctly completed the assignment.

## Submission
When you have completed the assignment (all tests pass) or it is reaching midnight of the due date, make sure you have completed the following:
1. Committed all changes to your repo
2. Pushed your changes to GitHub
3. Tagged your repo as "COMPLETE"
4. Pushed the "COMPLETE" tag to GitHub
5. Submitted your repository URL to Moodle in the Mission 01 submission section.

## Grading -- 50 Points
* Singly Link List -- 31 Points
* Scoreboard Class -- 4 Points
* Followed good programming practices: Specifically Program by Contract -- 2 Points
* Code style and documentation 10 points

## Hints
1. The basic implementation of the singly linked list is defined in the book in Chapter 3. I would suggest consulting this prior to beginning implementation
2. The basic implementation (which uses arrays) for the Scoreboard `add()` and `remove()` methods are depicted in code fragments 3.3 and 3.4 in the book. Use only as a reference but not as an implementation guideline. Do not worry about attempting to maintain the order of the list.

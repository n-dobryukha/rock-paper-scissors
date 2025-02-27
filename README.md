# Rock-Paper-Scissor

## Problem
Rock-Paper-Scissors is a game for two players. Each player simultaneously opens his/her hand to display
a symbol:
* Fist equals rock
* Open hand equals paper
* Showing the index and middle finger equals scissors.

The winner is determined by the following schema:
* Rock beats (blunts) scissors
* Paper beats (wraps) rock
* Scissors beats (cuts) paper.

Write a program that plays Rock-Paper-Scissors between the computer and a real player. You should be
able to play the game n times before the program exits.

###Run the app
    mvnw clean package exec:java

##Used external libraries
* JUnit - allows to create unit tests rapidly
* Mockito - allows to mock objects while performing unit tests
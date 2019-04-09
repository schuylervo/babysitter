# babysitter
This is a simple babysitter wage calculator written in Java and tested with JUnit.
## Introduction
This program calculates the total pay earned by a babysitter who works for one
of three different families, each of whom charges different hourly rates in different time bands.
I wrote this program to practice using Test Driven Development, 
including unit testing, and to practice solving time problems by using Java 8's time library.
## Rules
<ul>
<li>The babysitter only works for one of three possible families per night, each of whom
charges separate hourly rates in different in different pay bands. </li>
<li>The hourly wage earned by the babysitter is always rounded up to the next hour when a 
partial hour is worked within a particular pay band (e.g. 25 minutes of work is rounded
up to one hour, 65 minutes of work is rounded up to two hours). </li>
<li> The babysitter only works between the hours of 5:00pm and 4:00 a.m. </li>
<li>The babysitter (user) is prevented from making invalid time entries. </li>
</ul>

## Technologies used
<ul>
<li>Java</li>
<li>Local time objects included in the Java 8 library</li>
<li>Eclipse</li>
<li>Maven</li>
<li>Junit 4.13 beta</li>
</ul>

## Launch
This program can be run from the command line. The class file containing the main method is babykata.paythesitter.PayCalculatorApp.java



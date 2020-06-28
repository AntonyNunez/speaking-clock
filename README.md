Speaking clock
==============

Specification
-------------
1. Given a 24 hour clock convert the current time into words
	e.g. "08:34" should be converted to "It's eight thirty four"

2. Return Midday and Midnight as "It's Midday" and "It's Midnight"

The time allotted to the test is 1 hour. Your solution will be judged on a number of criteria pertinent to good
software development practice. Incomplete solutions are acceptable.

For the purposes of this exercise, please use Java 8 libraries.

Note
====
You can use tests to demonstrate your solution since there is no specific requirement to allow the application as a whole to be run.

Assumptions
-----------
I will probably need an array with some hours/minutes, but not all.

I have to ensure to input value is correct (format, range, numbers, ...).

To keep it simple, I will use the a.m./p.m. pattern.

I will probably have to calculate the minute numbers separately: 16:41 -> 41: 4 ("forty"); 1 ("one").

Running the solution
--------------------
Go to Run (menu) -> Run Configurations... -> Arguments (tab)

Click on Variables... and select ${string_prompt}

Click on Ok and click on Run.

Use the Ctrl+F11 combination to run the solution quickly.

Insert the desired time in the pop-up. Examples: 05:40, 12:00, 00:00, 22:07, ...

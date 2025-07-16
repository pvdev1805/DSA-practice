# Day 11

## Problem 1: Six Digits

***Task Description***:

Given six digits, find the earliest valid time that can be displayed on a digital clock (in 24-hour format) using those digits. For example, given digits 1, 8, 3, 2, 6, 4 the earliest valid time is "12:36:48". Note that "12:36:48" is not a valid time.

Write a function:

```java
    class Solution { public String solution(int A, int B, int C, int D, int E, int F); }
```

that, given six integers A, B, C, D, E and F, returns the earliest valid time in "HH:MM:SS" string format, or "NOT POSSIBLE" if it is not possible to display a valid time using all six integers.

For example, given 1, 8, 3, 2, 6, 4, the function should return "12:36:48".

Given 0, 0, 0, 0, 0, 0, the function should return "00:00:00".
Given 0, 0, 0, 7, 8, 9, the function should return "07:08:09".
Given 2, 4, 5, 9, 5, 9, the function should return "NOT POSSIBLE".

Assume that:
* A, B, C, D, E, and F are integers within the range [0..9].

In your solution, focus on **correctness**. The performance of your solution will not be the focus of the assessment.

## Problem 2: Calculate The Square

***Task Description***:

Write a function *solution* that, given two integers A and B, returns the maximum number of repeated square root operations that can be performed using the numbers from the interval [A..B] (both ends included) as starting points. Square root operations can be performed as long as the result is still an integer.

For example, given A = 10, B = 20, the function should return 2. Starting with the integer 16, two square root operations can be performed: *sqrt*(16) = 4 and then *sqrt*(4) = 2.

Given A = 6000 and B = 7000, the function should return 3. Starting with integer 6561, three square root operations can be performed: *sqrt*(6561) = 81, *sqrt*(81) = 9, and *sqrt*(9) = 3.

Write an efficient algorithm for the following assumptions:
* A and B are integers within the range [2..1,000,000,000];
* A <= B

## Problem 3: Public Transport Ticket

***Task Description***:

You want to buy public transport tickets for the upcoming month. You know exactly the days on which you will be traveling. The month has 30 days and there are three types of ticket:
* 1-day ticket, costs 2, valid for one day.
* 7-day ticket, costs 7, valid for seven consecutive days (e.g. if the first valid day is X, then the last valid day is X+6);
* 30-day ticket, costs 25, valid for all thirty days of the month.

You want to pay as little as possible.

You are given a sorted (in increasing order) array A of dates when you will be traveling. For example, given:

`A[0] = 1`  
`A[1] = 2`  
`A[2] = 4`  
`A[3] = 5`  
`A[4] = 7`  
`A[5] = 29`  
`A[6] = 30`

you can buy one 7-day ticket and two 1-day tickets. The two 1-day tickets should be used on days 29 and 30. The 7-day ticket should be used on the first seven days of the month. The total cost is 11 and there is no possible way of paying less.

Write a function:

```java
    class Solution { public int solution(int[] A); }
```

that, given an array A consisting of N integers that specifies days on which you will be traveling, returns the minimum amount of money that you have to spend on tickets for the month.

For example, given the above data, the function should return 11, as explained above.

Assume that:
* N is an integer within the range [0..30];
* each element of array A is an integer within the range [1..30];
* array A is sorted increasing order;
* the elements of A are all distinct.
  
# Day 1

## Problem 1: Binary Gap

***Task Description***:

A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:
```java
    class Solution { public int solution(int N); }
```
that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn’t contain a binary gap.

For example, given N = 1041, the function should return 0, because N has binary representation ‘100000’ and thus no binary gaps.
Write an efficient algorithm for the following assumptions:
* N is an integer within the range [1 .. 2,147,483,647]

## Problem 2: Same Sum Dice

***Task Description***:

There are two sets of traditional six-faced dice, represented by two arrays A and B consisting of N and M integers respectively. Each array element has a value between 1 and 6, inclusive, representing the value of the corresponding dice.

Write a function:
```java
    class Solution { public int solution(int[] A, int[] B); }
```
that, given two arrays A and B, returns the minimum number of dice to be turned in order to make the sums of dice in both sets equal, or -1 if this is not possible.

Examples:
1/ Given A = [5] , B = [1, 1, 6] , the function should return 1. We have to turn the third dice in B from 6 to 3; then the arrays will have the same sums (5 = 1 + 1 + 3)
2/ Given A = [2, 3, 1, 1, 2] , B = [5, 4, 6] , the function should return 2. We can turn the last two dice in B to get [5, 1, 3]; then the arrays will have the same sum.
3/ Given A = [5, 4, 1, 2, 6, 5] , B = [2] , the function should return 6. We can turn 5 dice in A to get [1, 1, 1, 1, 1, 1] and one dice in B to get [6]; then the arrays will have the same sum.
4/ Given A = [1, 2, 3, 4, 3, 2, 1] , B = [6] , the function should return -1, because it is not possible for the arrays to have the same sum.

Write an efficient algorithm for the following assumptions:
* N and M are integers within the range [1 .. 100,000]
* Each element of arrays is an integers within the range [1 .. 6]

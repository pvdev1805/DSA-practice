# Day 2

## Problem 1: Find Interval In Array

_Medium_
_50 Minutes_

Given an array of integers and an interval of values, find the shortest fragment of A that contains all the integers from the interval.

***Task Description***:

There is an array A, consisting of N integers, and two integers, L and R. Your task is to find the shortest fragment of consecutive elements of A that contains every integer from L to R inclusive.
Write a function:

```java
    class Solution { public int solution(int[] A, int L, int R); }
```

that, given A, L and R, returns the length of the shortest fragment of A that contains all numbers from L to R. If no such fragment exists, the function should return −1.
Examples:

1. Given A = [2, 1, 4, 3, 2, 1, 1, 4], L = 2 and R = 4, the function should return 3. The shortest fragment containing the numbers 2, 3 and 4 starts at the third element of A: [2, 1, 4, 3, 2, 1, 1, 4]
2. Given A = [109, 1, 1, 1, 1, 1, 109−1], L = 109−1 and R = 109, the function should return 7. The fragment is the whole array.
3. Given A = [1, 3, 5, 7], L = 3 and R = 5, the function should return −1. Array A does not contain the number 4.

Write an efficient algorithm for the following assumptions:
* N is an integer within the range [1..100,000];
* 1 ≤ L ≤ R ≤ 1,000,000,000;
* each element of array A is an integer within the range [1..1,000,000,000].

## Problem 2: Optimizing Farthest Different

_Medium_
_55 Minutes_

You are given an implementation of a function:

```java
    class Solution { public int solution(int[] A); }
```

which accepts as input a non-empty array A consisting of N integers.

The function works slowly on large input data and the goal is to optimize it so as to achieve better time and/or space complexity. The optimized function should return the same result as the given implementation for every input that satisfies the assumptions.

For examples, given array A such that:

```java
    A[0] = 4; A[1] = 6; A[2] = 2; A[3] = 2; A[4] = 6; A[5] = 6; A[6] = 4; 
```

the function returns 5.

Also, for the given array A such that:
 
```java
    A[0] = 0; A[1] = 1; ... ; A[74999] = 74999; A[75000] = 75000; 
```
 
 in other words, A[K] = K for each K( O <= K <= 75000), the given implementation works too slow, but the function would return 75000.
 
 Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1 .. 100000].
 * each element of array A is an integer within the range [-1,000,000,000 .. 1,000,000,000].
 
 _The original code is:_
 
```java
    import java.until.*;
    
    class Solution {
    	int solution(int[] A){
    		int N = A.length;
    		int result = 0;
    		for(int i = 0; i < N; i++){
    			for(int j = i; j < N; j++){
    				if(A[i] != A[j]){
    					result = Math.max(result, j - i);
    				}
    			}
    		}
    		return result;
    	}
    }
```
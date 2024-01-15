### Leet code

I like in LeetCode its respectful set of programming exercises. 
Everything is OK, until you try to understand what they want from your life. 
The Biggest issues are not clear description. The level of the problem is opinionated.

Next, when you try to find explanation on youtube rarely you have getting good blogger.
It is a crap. 


#### Longest palindromic substring

```agsl
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
```

The brute force is two loops.
The next idea is center of palindrome and left and right pointers.

Most efficient algorithm **Manacher's algorithm**

Idea #1: how to handle even len of the String? We may insert a sign, for example '#', our input Sring can be:

#b#a#b#a#d# - len is 11

#c#b#b#d#   - len is 9, was even became odd. Amazing

O(N^2) can be modified to O(N)




“Minimum Window Subsequence” is the problem where:

You are given two strings s1 and s2.

You need to find the smallest substring of s1 such that s2 appears in it as a subsequence.

A subsequence means the characters of s2 must appear in order, but they do not need to be contiguous.

If there are multiple answers with the same minimum length, return the one with the leftmost starting index.

If no such window exists, return "".

Example
s1 = "abcdebdde"
s2 = "bde"

Output:

"bcde"
Why?

Because "bde" is a subsequence of "bcde":

b matched
d matched
e matched

and "bcde" is the smallest such substring.

Difference from Minimum Window Substring

In Minimum Window Substring:

all characters must be present with frequency
order does not matter

In Minimum Window Subsequence:

characters must appear in order
they do not need to be adjacent


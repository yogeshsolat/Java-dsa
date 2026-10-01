# Dynamic Programming

These are early exercises showing two ways to reuse answers to smaller problems. The recursive definitions remain visible; memoization caches their results, while tabulation fills answers from the base case upward.

| File | Problem and approach | Base case | Time / space |
|---|---|---|---|
| `Fibonacci.java` | Compute Fibonacci with top-down memoization. The `qb` array stores values already calculated. | Return `n` for `n = 0` or `n = 1`. | `O(n)` time, `O(n)` cache plus `O(n)` call stack. |
| `StairPathDP.java` | Count ways to climb using steps of 1, 2, or 3. Includes memoized recursion and bottom-up tabulation. | One way to be at step 0; zero ways for a negative step count. | Both methods `O(n)` time and `O(n)` storage; memoized version also uses `O(n)` stack. |

This folder is the next learning area after recursion: compare the repeated recursive subproblems with the cached or table-based versions.

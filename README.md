# Java DSA Learning

This repository is my working notebook for learning data structures and algorithms in Java. The code records the problems I have attempted and the ideas I am practicing; it is meant to support my own revision, not to present every solution as a finished reference implementation.

## Learning journey

I am building problem-solving habits topic by topic: first tracing a straightforward recursive solution, then understanding how choices branch and how state is restored, and then learning how dynamic programming reuses repeated results. The examples and notes are kept close to that learning process.

## Topics and progress

- **Recursion** — current focus: base cases, recursive calls, returning results versus printing them, and backtracking.
- **Dynamic Programming** — early practice with memoization and tabulation for Fibonacci numbers and stair paths; this is the next focus after recursion.

## Repository structure

```text
recursion/   Recursive problems and a note about return-value versus void recursion
 dp/         Early memoization and tabulation exercises
```

See [recursion/README.md](recursion/README.md) and [dp/README.md](dp/README.md) for topic maps and revision notes.

## How I practice

I try a problem in my own style, trace small inputs to understand what each call represents, and compare alternatives only to clarify the idea. Notes focus on the base case, what each call contributes, and—when state changes—what must be undone while backtracking. Implementations may reflect work in progress, so I revisit them as I learn.


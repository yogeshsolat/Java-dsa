# Recursion

Current learning focus: understand what a call represents, choose a base case that returns or prints the right result, and track how the answer is built. The code includes both methods that return collections and methods that print results directly; [gold_for_return_and_void.md](gold_for_return_and_void.md) captures that distinction.

## File map and revision notes

| File | Problem / idea | Approach and base case | Cost (for the shown input) |
|---|---|---|---|
| `GetFibonacci.java` | Return Fibonacci number `n` | Two recursive subproblems, `n-1` and `n-2`; return `n` for `n` equal to 0 or 1. | Time `O(2^n)`; stack `O(n)`. |
| `PFibonacci.java` | Print a Fibonacci sequence | Carry the next pair of values and remaining count through recursion; stop when the requested count is reached. Also includes an iterative version. | Recursive version: `O(k)` time and `O(k)` stack for `k` printed values; iterative version: `O(k)` time, `O(1)` auxiliary space. |
| `Subsequence.java` | Print every subsequence | For each character, branch into include and exclude calls; when no question characters remain, print the built answer. | `O(2^n)` outputs/calls (excluding string-copying costs); `O(n)` stack. |
| `Subset.java` | Print subsets reaching a target sum | At each index, choose the value or skip it; stop and print on target, or prune when the sum exceeds target. | Worst case `O(2^n)` calls; `O(n)` stack. |
| `KeypadCombination.java` | Print letter combinations for digit input | For the first digit, try each mapped letter and recurse on the remaining digits; print when none remain. | `O(product of mapping sizes)` outputs, with `O(n)` stack for `n` digits. |
| `PEncoding.java` | Print valid alphabet encodings of digits | Try a one-digit mapping and, when valid, a two-digit mapping; print when the input is consumed. | Up to `O(2^n)` branches for `n` digits; `O(n)` stack. |
| `StairPath.java`, `PStairPath.java` | Enumerate ways to climb using steps 1, 2, or 3 | Branch by each allowed step. Reaching 0 is one complete path; a negative remainder is invalid. One version returns paths, the other prints them. | Exponential number of paths/calls (bounded by `O(3^n)`); `O(n)` stack. Returned paths also require output-sized memory. |
| `MazePath.java`, `PMazePath.java` | Enumerate right/down paths on a grid | Recurse one cell down or right. At the destination, return the empty suffix or print the accumulated path. | `O(\binom{r+c}{r})` paths for a grid `r` by `c` moves; recursion depth `O(r+c)`. Collection version uses output-sized memory. |
| `MazePathPro.java`, `PMazePathPro.java` | Enumerate paths with horizontal, vertical, and diagonal jumps | Try every legal jump length in each allowed direction. Reaching the destination ends a path. | Output-sensitive; number of paths grows exponentially with grid dimensions. Maximum recursion depth `O(r+c)`. |
| `FloodFill.java` | Print paths through an open grid without revisiting a cell on the current path | Reject bounds, blocked, and currently visited cells; print at destination. Mark before exploring neighbors and unmark after all branches (backtracking). | Exponential in the number of open cells in the worst case; `O(rc)` visited-state and recursion depth at most `O(rc)` for an `r` by `c` grid. |
| `PPermutation.java` | Print permutations of a string | Choose each character in turn, recurse with that character removed, and print when no characters remain. | `O(n · n!)` output work; `O(n)` recursion depth, apart from strings created along the way. |
| `NQueens.java` | Place one queen per row without column/diagonal conflicts | Try each safe column; after recursing to the next row, remove the queen so the next choice starts from the prior board. Base case: all rows placed. | Worst-case search is factorial-scale; each safety check scans up to `O(n)` cells. Stack `O(n)`, board `O(n²)`. |
| `KnightsTour.java` | Explore knight moves until every square is visited | Reject off-board or occupied squares; mark a move, try all eight next moves, then clear it on return. Print when the final square is reached. | Exponential search in the number of squares (up to 8 choices per level); stack `O(n²)` and board `O(n²)` for an `n × n` board. |

Complexities describe the algorithms at a high level; printing or returning every answer necessarily adds work proportional to the total output. `Subset.java` assumes non-negative values for its `sum > target` pruning to be valid.

## Recursion reminders

- A base case should describe a completed answer and return immediately, or reject an invalid state.
- In a collection-returning method, recursive calls bring back future results; the current choice is added to each returned result.
- In a `void` printer, pass the partial answer forward as each choice is made.
- In backtracking, restore mutable state after recursive calls so sibling choices start cleanly.

# Recursion: Faith & Expectation vs Level & Options

> Revision notes inspired by Pepcoding and Sumit Sir's approach. The goal is to understand the thinking behind recursion, not just memorize code.

## 1. The Big Picture

There are two useful ways to think about recursion:

1. **Faith & Expectation (FE)** — Trust the smaller recursive call to solve its problem. When it returns the answer, use that answer to build your own.
2. **Level & Options (LO)** — At every level, identify the available choices, explore each choice recursively, and build the answer along the way.

**In simple words:**

- FE: Ask recursion for an answer, receive it, and do your work.
- LO: Make a choice, go deeper, and explore all possible choices.

These are thinking techniques, not strict rules. Some problems can be solved using either approach.

---

# 2. Faith & Expectation (FE)

## The Core Idea

Whenever you solve a problem using FE, ask yourself three questions:

- **Expectation:** What do I want my current function to return?
- **Faith:** Can I trust a smaller recursive call to solve a smaller version of the same problem?
- **My work:** After receiving its answer, what should I do to construct my answer?

The recursive call handles the smaller problem. Once it returns, the current function uses its result to calculate its own answer.

### Example: Get Maze Paths

Suppose we want to find all paths from a starting cell to a destination. We can move:

- `H` — one step horizontally (right).
- `V` — one step vertically (down).

Imagine we are currently at a cell.

Instead of calculating every complete path ourselves, we ask recursion:

- What paths are possible if I move down first?
- What paths are possible if I move right first?

Once recursion returns those paths, we add our own move to each returned path.

```java
static ArrayList<String> getMazePaths(
        int sr, int sc, int dr, int dc) {

    if (sr == dr && sc == dc) {
        ArrayList<String> base = new ArrayList<>();
        base.add("");
        return base;
    }

    ArrayList<String> paths = new ArrayList<>();

    if (sr < dr) {
        ArrayList<String> verticalPaths =
                getMazePaths(sr + 1, sc, dr, dc);

        for (String path : verticalPaths) {
            paths.add("V" + path);
        }
    }

    if (sc < dc) {
        ArrayList<String> horizontalPaths =
                getMazePaths(sr, sc + 1, dr, dc);

        for (String path : horizontalPaths) {
            paths.add("H" + path);
        }
    }

    return paths;
}
```

## Understand the Flow

Suppose the smaller recursive call returns:

```text
["HH", "HV", "VH"]
```

Our current call can add its own move:

```text
"H" + "HH" = "HHH"
"H" + "HV" = "HHV"
"H" + "VH" = "HVH"
```

The smaller call has already found the remaining paths. We only need to add the move that takes us from the current cell to the smaller problem's starting cell.

### Why does the base case return `""`?

At the destination, there are no more moves to make. The remaining path is an empty string.

But notice the difference:

```java
return new ArrayList<>(List.of(""));
```

means there is **one valid path with no moves remaining**.

An empty list means there are **zero valid paths**.

This distinction is important when returning collections of recursive answers.

## FE Mental Model

```text
Current problem
      |
      v
Ask smaller recursive problems for answers
      |
      v
Receive their answers
      |
      v
Add my contribution to those answers
      |
      v
Return my completed answer
```

**Remember:** In FE, recursive calls go deeper first. Their answers return upward, and we use those answers while the call stack unwinds.

### Other FE Examples

- `getMazePaths()` — return all possible paths.
- `getStairPaths()` — return all possible ways to climb stairs.
- `getSubsequence()` — return all subsequences.
- `fibonacci(n)` — calculate a value using smaller Fibonacci values.

The central question is:

> If the smaller problem is already solved, how can I use its answer to solve my current problem?

---

# 3. Level & Options (LO)

## The Core Idea

In LO, we think of the problem as a series of decisions.

At every level:

1. Identify the current decision.
2. List all valid options.
3. Choose one option.
4. Make a recursive call.
5. Return and explore the remaining options.

Here, we often carry the partial answer as a parameter. When we reach the base case, the answer is complete, so we print or process it.

### Example: Print Maze Paths

Again, we can move right (`H`) or down (`V`).

```java
static void printMazePaths(
        int sr, int sc, int dr, int dc, String path) {

    if (sr == dr && sc == dc) {
        System.out.println(path);
        return;
    }

    if (sr < dr) {
        printMazePaths(sr + 1, sc, dr, dc, path + "V");
    }

    if (sc < dc) {
        printMazePaths(sr, sc + 1, dr, dc, path + "H");
    }
}
```

Call it using:

```java
printMazePaths(1, 1, 3, 3, "");
```

Here, `path` contains the answer built so far.

At every cell, we explore the available moves. When we reach the destination, we print the completed path.

## What Does "Every Level Has Options" Mean?

At the current cell, we have these options:

```text
Option 1: Move down
          Add V to the path
          Make a recursive call

Option 2: Move right
          Add H to the path
          Make a recursive call
```

Each recursive call explores its own options until it reaches a base case.

## Example: Print Subsequences

For the string `"ab"`, every character has two options:

- Include the character.
- Exclude the character.

```java
static void printSubsequences(String str, String answer) {

    if (str.isEmpty()) {
        System.out.println(answer);
        return;
    }

    char ch = str.charAt(0);
    String rest = str.substring(1);

    // Option 1: Include the current character
    printSubsequences(rest, answer + ch);

    // Option 2: Exclude the current character
    printSubsequences(rest, answer);
}
```

Call:

```java
printSubsequences("ab", "");
```

Output:

```text
ab
a
b

```

The final line is an empty subsequence.

At the level for `a`, we choose whether to include or exclude it. Then we make the same decision for `b`.

Every route through the recursion tree represents one possible subsequence.

## LO Mental Model

```text
Current level
      |
      v
Identify available options
      |
      v
Choose one option
      |
      v
Update the partial answer
      |
      v
Make a recursive call
      |
      v
Reach base case and process answer
      |
      v
Return and explore the next option
```

**Remember:** In LO, we build the answer as we go deeper. At the base case, we have completed one possible answer.

### Other LO Examples

- `printMazePaths()` — choose a direction at every cell.
- `printSubsequences()` — include or exclude each character.
- `printPermutations()` — choose a character for the current position.
- `printNQueens()` — choose a safe column for the current row.
- `printStairPaths()` — choose an allowed step at every level.

Some LO problems require **backtracking**. If you modify a shared array, list, or board before making a recursive call, undo that change after the call returns so the next option starts with the correct state.

With immutable strings such as `path + "H"`, you don't need to undo the string change because each call receives its own string value.

---

# 4. FE vs LO: Quick Comparison

| Question | Faith & Expectation | Level & Options |
|---|---|---|
| Main question | If the smaller problem gives me its answer, how do I build mine? | What choices do I have at this level? |
| Main approach | Ask for answers and combine them | Choose options and explore them |
| Typical direction of work | Combine answers while returning upward | Build the partial answer while going downward |
| Where is the answer built? | Often by combining returned values | Often by carrying a partial answer in parameters |
| Base case | Return the smallest valid result | Process the completed answer |
| Common examples | `getMazePaths()`, `getStairPaths()` | `printMazePaths()`, `printSubsequences()` |

**Important:** "Get" and "print" are useful clues in Pepcoding-style examples, but they are not universal rules. A `get` function can still explore options, and a `print` function can still use returned values. Always examine how the answer flows through the code.

---

# 5. How to Decide Which Approach to Use

When you encounter a new recursion problem, ask these questions before writing code.

### Question 1: What should my function do?

Does it need to:

- Return one value?
- Return a collection of answers?
- Print all possible answers?
- Count the number of ways?
- Find just one valid solution?

Clearly defining the function's responsibility makes recursion easier.

### Question 2: Can I trust a smaller problem to solve itself?

For example:

> If `getMazePaths()` can give me all paths from the next cell to the destination, can I add my current move to those paths?

If yes, try FE.

### Question 3: Is the problem naturally about choices?

For example:

> At each character, should I include it or exclude it?

Or:

> At each cell, should I move right or down?

If yes, try LO.

### Question 4: What should happen at the base case?

Should the function:

- Return a value?
- Return a collection?
- Print a completed answer?
- Update a count?
- Indicate whether a solution exists?

The base case must match the responsibility of the function.

### Question 5: Where does the answer come from?

- If you receive smaller answers and combine them, you are thinking in FE terms.
- If you carry a partial answer and make decisions at each level, you are thinking in LO terms.

You don't have to identify the perfect approach immediately. Define the function, solve a tiny example by hand, and trace the recursive calls.

---

# 6. Common Mistakes

### Mistake 1: Thinking FE means recursion only works upward

Incorrect. Recursive calls go downward first. Their returned answers are combined while the call stack unwinds.

### Mistake 2: Thinking LO always means two recursive calls

Incorrect. The number of recursive calls depends on the number of valid options at the current level.

### Mistake 3: Returning the wrong base-case value

For a function returning paths, an empty string and an empty collection mean different things.

```text
[""]  -> One valid empty remaining path
[]    -> No valid paths
```

### Mistake 4: Confusing printing with returning

```java
System.out.println(answer);
```

displays an answer.

```java
return answer;
```

sends a value back to the caller.

These operations are not interchangeable.

### Mistake 5: Forcing every problem into one template

FE and LO are mental models, not rigid categories. Focus on the function's responsibility and the way information flows.

### Mistake 6: Forgetting to backtrack

When modifying shared mutable state, undo the modification after exploring a branch if the next branch must start from the previous state.

---

# 7. One-Minute Revision

## Faith & Expectation

**Ask → Receive → Combine → Return**

"I trust the smaller recursive call to solve its problem. When its answer comes back, I use it to build my current answer."

Example: `getMazePaths()`

## Level & Options

**Choose → Recurse → Complete → Try Next**

"At each level, I explore the available options. I carry the partial answer down and process it when I reach the base case."

Examples: `printMazePaths()`, `printSubsequences()`

---

# 8. Test Your Understanding

Try answering these without looking at the notes.

1. Why does `getMazePaths()` return a collection instead of printing every path?
2. Why does its base case return a collection containing an empty string?
3. In `printMazePaths()`, where is the partial answer stored?
4. In `printSubsequences()`, why do we make two recursive calls?
5. What is the difference between returning an answer and printing an answer?
6. Can a problem be solved using both FE and LO? Why?
7. When is backtracking necessary?

## Final Takeaway

**FE:** "You solve the smaller problem. I will use your answer to solve mine."

**LO:** "I will explore every valid choice, one by one, and build the answer along the way."

If you understand these two sentences and can explain the flow of `getMazePaths()` versus `printMazePaths()`, you have understood the core idea behind these two recursion styles.
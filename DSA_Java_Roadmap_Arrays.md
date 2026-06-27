# DSA in Java — Zero to Strong Arrays

A complete path from Java basics → complexity analysis → Arrays mastery, with code, explanations, and LeetCode practice at every step.

---

## PHASE 0: Java Prerequisites (you need these before DSA makes sense)

You don't need to be a Java expert, but you must be 100% comfortable with the following.

### 0.1 Variables & Data Types
```java
int a = 10;
long b = 100000000000L;
double c = 3.14;
char ch = 'A';
boolean flag = true;
String s = "hello";
```
- `int` → 32-bit (~2.1 billion range). Use `long` when numbers can exceed ~2×10^9 (very common in DSA — sums, factorials, etc.)
- Know the difference between primitive types (`int`, `char`) and objects (`String`, `Integer`).

### 0.2 Operators
- Arithmetic: `+ - * / %`
- Be careful: `7 / 2 = 3` (integer division), `7 % 2 = 1` (remainder)
- Comparison: `== != < > <= >=`
- Logical: `&& || !`
- Increment/decrement: `++ --` (pre vs post matters in tricky problems)
- Bitwise (important later): `& | ^ ~ << >>`

### 0.3 Conditionals & Loops
```java
if (a > b) { } else if (a == b) { } else { }

for (int i = 0; i < n; i++) { }
while (condition) { }
do { } while (condition);
```
- **Master the `for` loop fully** — most array problems are loop manipulation.

### 0.4 Methods (Functions)
```java
public static int add(int a, int b) {
    return a + b;
}
```
- Understand parameters, return types, and **pass-by-value** (Java passes a copy of primitives, but passes the reference for arrays/objects — this matters a lot in DSA).

### 0.5 Arrays — Java Syntax Basics
```java
int[] arr = new int[5];          // declare with size, default values = 0
int[] arr2 = {1, 2, 3, 4, 5};    // declare with values
int n = arr.length;               // length (no parentheses, it's a field not method)
arr[0] = 10;                      // access/assign by index (0-based)
```
- 2D array:
```java
int[][] matrix = new int[3][4];   // 3 rows, 4 cols
int[][] matrix2 = {{1,2},{3,4}};
```

### 0.6 Scanner (Input)
```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
```

**Practice (not LeetCode, just to warm up in plain Java):**
- Write a program to find sum of digits of a number
- Write a program to check if a number is prime
- Reverse a number
- Check Armstrong number

---

## PHASE 1: Time & Space Complexity (the most important theory in all of DSA)

You cannot evaluate if your solution is "good" without this. Spend real time here.

### 1.1 Why it matters
Two solutions can give the correct output, but one might take 1 second and the other 10 minutes for large inputs. Complexity tells you **how your code scales** as input size `n` grows.

### 1.2 Big O Notation
Big O describes the **worst-case growth rate** of time/space relative to input size `n`.

| Complexity | Name | Example |
|---|---|---|
| O(1) | Constant | accessing `arr[5]` |
| O(log n) | Logarithmic | binary search |
| O(n) | Linear | one loop through array |
| O(n log n) | Linearithmic | merge sort, quick sort |
| O(n²) | Quadratic | nested loop (bubble sort) |
| O(2^n) | Exponential | recursive subsets/Fibonacci (naive) |
| O(n!) | Factorial | permutations |

### 1.3 How to calculate it yourself
Rules of thumb:
- A single loop from `0` to `n` → O(n)
- A loop inside a loop (both up to n) → O(n²)
- Loop that halves the range each time (`i = i*2` or binary search) → O(log n)
- Drop constants: O(3n) = O(n). Drop lower order terms: O(n² + n) = O(n²)
- Different loops one after another (not nested) → you **add**: O(n) + O(n) = O(n)
- Nested loops → you **multiply**: O(n) * O(n) = O(n²)

```java
// O(n) — single pass
for (int i = 0; i < n; i++) { /* work */ }

// O(n^2) — nested
for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) { /* work */ }

// O(log n) — halving
int i = n;
while (i > 1) { i = i / 2; }
```

### 1.4 Space Complexity
Same idea, but for memory used (extra variables, arrays, recursion stack) instead of time.
- An extra array of size `n` → O(n) space
- Just a few variables, no matter the input → O(1) space (in-place)

**You should be able to answer "what's the time and space complexity?" for every solution you write, going forward. This is asked in every interview.**

---

## PHASE 2: Basic Math for DSA (useful, comes up often)

- **GCD/LCM** (Euclidean algorithm)
```java
int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}
```
- **Prime check** — O(√n) method (loop till `i*i <= n`)
- **Factorial, power** using loops
- **Bit manipulation basics**: `&`, `|`, `^`, `<<`, `>>`, checking if a number is even/odd via `n & 1`

**LeetCode practice for this phase:**
| Problem | LeetCode # | Difficulty |
|---|---|---|
| Reverse Integer | 7 | Easy |
| Palindrome Number | 9 | Easy |
| Count Primes | 204 | Medium |
| Number of 1 Bits | 191 | Easy |
| Power of Two | 231 | Easy |
| Fibonacci Number | 509 | Easy |

---

## PHASE 3: Arrays — The Full Deep Dive

This is the core of your request. Arrays are the **foundation of all DSA** — strings, matrices, hashing, two pointers, sliding window, and sorting all build on this.

### 3.1 What is an Array, really?
- A contiguous block of memory storing elements of the same type.
- Each element accessed in **O(1)** via index because the computer calculates the memory address directly: `address = base_address + index * size_of_type`.
- This is *why* array access is instant but **insertion/deletion in the middle is slow (O(n))** — everything after the index has to shift.

### 3.2 Core Operations & Their Complexity
| Operation | Time Complexity | Why |
|---|---|---|
| Access by index | O(1) | direct address calculation |
| Search (unsorted) | O(n) | must check every element (linear search) |
| Search (sorted) | O(log n) | binary search |
| Insertion at end | O(1)* | if space available |
| Insertion at start/middle | O(n) | must shift elements |
| Deletion | O(n) | must shift elements after the gap |

### 3.3 Traversal
```java
int[] arr = {1, 2, 3, 4, 5};
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
// or
for (int x : arr) { System.out.println(x); }
```

### 3.4 Linear Search
```java
int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) return i;
    }
    return -1;
}
```
Time: O(n), Space: O(1)

### 3.5 Binary Search (array must be sorted)
```java
int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;   // avoids overflow vs (low+high)/2
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
}
```
Time: O(log n), Space: O(1). **Understand why**: each step you eliminate half the remaining elements.

### 3.6 Basic Sorting Algorithms (understand these manually before using built-in sort)

**Bubble Sort** — repeatedly swap adjacent elements if out of order.
```java
void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
            }
        }
    }
}
```
O(n²) time, O(1) space.

**Selection Sort** — find min, put it at the front, repeat.
**Insertion Sort** — build sorted array one element at a time (good for small/nearly-sorted arrays).

You don't need to master Merge Sort/Quick Sort right now (that's the next phase, "Recursion & Sorting"), but know they exist at O(n log n) and are why `Arrays.sort()` is fast.

```java
int[] arr = {5,3,1,4};
Arrays.sort(arr);   // built-in, O(n log n)
```

### 3.7 Two Pointer Technique
Use two indices moving through the array (often from both ends, or both moving forward) to avoid nested loops — turns many O(n²) problems into O(n).
```java
// Example: check if array has a pair summing to target (sorted array)
boolean hasPair(int[] arr, int target) {
    int l = 0, r = arr.length - 1;
    while (l < r) {
        int sum = arr[l] + arr[r];
        if (sum == target) return true;
        else if (sum < target) l++;
        else r--;
    }
    return false;
}
```

### 3.8 Sliding Window Technique
Maintain a "window" (subarray) and expand/shrink it instead of recomputing from scratch — very common for subarray/substring problems.
```java
// Example: max sum of subarray of size k
int maxSumSubarray(int[] arr, int k) {
    int windowSum = 0, maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
        windowSum += arr[i];
        if (i >= k - 1) {
            maxSum = Math.max(maxSum, windowSum);
            windowSum -= arr[i - k + 1];
        }
    }
    return maxSum;
}
```

### 3.9 Prefix Sum
Precompute cumulative sums so range-sum queries become O(1) instead of O(n) each.
```java
int[] prefix = new int[arr.length + 1];
for (int i = 0; i < arr.length; i++) prefix[i+1] = prefix[i] + arr[i];
// sum of arr[l..r] = prefix[r+1] - prefix[l]
```

### 3.10 Kadane's Algorithm (Maximum Subarray Sum)
A classic must-know pattern.
```java
int maxSubArray(int[] arr) {
    int maxSoFar = arr[0], currMax = arr[0];
    for (int i = 1; i < arr.length; i++) {
        currMax = Math.max(arr[i], currMax + arr[i]);
        maxSoFar = Math.max(maxSoFar, currMax);
    }
    return maxSoFar;
}
```

### 3.11 2D Arrays (Matrices)
```java
int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
}
```
Know how to: traverse row-wise, column-wise, diagonally, and transpose/rotate.

---

## PHASE 4: LeetCode Practice List (in solving order)

Solve these **in this order**. Don't skip ahead — each builds intuition for the next.

### Step 1 — Basic traversal & manipulation
| # | Problem | Difficulty |
|---|---|---|
| 1929 | Concatenation of Array | Easy |
| 1480 | Running Sum of 1d Array | Easy |
| 27 | Remove Element | Easy |
| 26 | Remove Duplicates from Sorted Array | Easy |
| 66 | Plus One | Easy |
| 283 | Move Zeroes | Easy |
| 448 | Find All Numbers Disappeared in an Array | Easy |
| 169 | Majority Element | Easy |

### Step 2 — Searching
| # | Problem | Difficulty |
|---|---|---|
| 704 | Binary Search | Easy |
| 35 | Search Insert Position | Easy |
| 33 | Search in Rotated Sorted Array | Medium |
| 153 | Find Minimum in Rotated Sorted Array | Medium |
| 278 | First Bad Version | Easy |

### Step 3 — Hashing-with-array problems (very common interview question)
| # | Problem | Difficulty |
|---|---|---|
| 1 | Two Sum | Easy |
| 217 | Contains Duplicate | Easy |
| 268 | Missing Number | Easy |
| 136 | Single Number | Easy |

### Step 4 — Two Pointers
| # | Problem | Difficulty |
|---|---|---|
| 344 | Reverse String | Easy |
| 977 | Squares of a Sorted Array | Easy |
| 167 | Two Sum II – Input Array Is Sorted | Medium |
| 11 | Container With Most Water | Medium |
| 15 | 3Sum | Medium |
| 75 | Sort Colors | Medium |

### Step 5 — Sliding Window
| # | Problem | Difficulty |
|---|---|---|
| 121 | Best Time to Buy and Sell Stock | Easy |
| 643 | Maximum Average Subarray I | Easy |
| 209 | Minimum Size Subarray Sum | Medium |
| 3 | Longest Substring Without Repeating Characters | Medium (string, but same technique) |

### Step 6 — Prefix Sum / Kadane's
| # | Problem | Difficulty |
|---|---|---|
| 53 | Maximum Subarray | Medium |
| 724 | Find Pivot Index | Easy |
| 303 | Range Sum Query – Immutable | Easy |
| 238 | Product of Array Except Self | Medium |

### Step 7 — Sorting-based
| # | Problem | Difficulty |
|---|---|---|
| 912 | Sort an Array | Medium |
| 56 | Merge Intervals | Medium |
| 88 | Merge Sorted Array | Easy |

### Step 8 — 2D Arrays / Matrices
| # | Problem | Difficulty |
|---|---|---|
| 73 | Set Matrix Zeroes | Medium |
| 54 | Spiral Matrix | Medium |
| 48 | Rotate Image | Medium |
| 36 | Valid Sudoku | Medium |

### Step 9 — Rotation & rearrangement (good revision set)
| # | Problem | Difficulty |
|---|---|---|
| 189 | Rotate Array | Medium |
| 41 | First Missing Positive | Hard (attempt after the rest) |
| 31 | Next Permutation | Medium |

---

## How to actually use this guide
1. Go phase by phase — don't jump to LeetCode before you can explain Big O out loud.
2. For every problem: first write the **brute force** (even if O(n²)), get it accepted, *then* think about optimizing to the better technique (two pointer/sliding window/prefix sum).
3. After solving, always ask yourself: "What's the time and space complexity of my solution? Could it be better?"
4. Re-solve Two Sum, Maximum Subarray, and Binary Search from scratch (no looking at old code) after a week — repetition is what makes patterns permanent.

Once Arrays feel solid (you can solve Step 1–6 problems without hints), the natural next topics are: **Strings, Recursion, Linked Lists, then Sorting algorithms (Merge/Quick Sort) and Searching algorithms in depth** — happy to map that phase out too whenever you're ready.

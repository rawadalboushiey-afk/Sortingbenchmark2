# Sorting Algorithms Benchmark

- **Student Name:** رواد محمد البوعيشي
- **University ID:** 3169061
- **Section / Class:** [رقم الشعبة]

---

## 1. Benchmark Results (Nanoseconds - $ns$)

| Algorithm | Scenario | Execution Time ($ns$) |
| :--- | :--- | :---: |
| **Quick Sort** | **Random** | 23295899 |
| **Quick Sort** | **Fully Sorted** | Overflow |

---

## 2. Analysis and Discussion

### Quick Sort Behavior & Pivot Impact
- **Quick Sort** relies heavily on the choice of the Pivot element. When tested on a **Fully Sorted** dataset using a naive pivot selection (such as choosing the last element), the partitioning results in highly unbalanced sub-arrays. 
- This causes the recursion depth to reach $O(N)$, ultimately triggering a `StackOverflowError` (Overflow) due to the exhaustion of the maximum call stack limit.
- On **Random** data, the pivot divides the array more evenly, allowing Quick Sort to operate with high efficiency and achieve an average time complexity of $O(N \log N)$.

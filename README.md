# DAA Assignment 2 - Kadane's Algorithm

## Algorithm Overview
Kadane's Algorithm for maximum subarray sum with position tracking.

## Key Features
- Single-pass O(n) algorithm
- Tracks start/end indices of maximum subarray  
- Performance metrics (comparisons, array accesses)
- Comprehensive test suite (7 unit tests)
- CLI benchmark runner with CSV export

## Complexity
- **Time**: O(n) all cases
- **Space**: O(1) auxiliary
- **Operations**: 4n - 2 exact count

## Quick Start
```bash
mvn compile
mvn test
mvn exec:java

```

## Results
Performance data exported to `kadane_performance.csv`:
- Confirmed O(n) time complexity
- Linear operations growth: 398 → 3998 → 39998 → 399998
```

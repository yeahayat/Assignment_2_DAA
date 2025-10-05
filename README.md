# DAA Assignment 2 - Kadane's Algorithm

## Performance Results

### Runtime Measurements (microseconds)

| Input Size | Time (μs) | Operations | Array Accesses |
|------------|-----------|------------|----------------|
| 100        | 541       | 398        | 298            |
| 1000       | 50        | 3,998      | 2,998          |
| 10000      | 486       | 39,998     | 29,998         |
| 100000     | 3,080     | 399,998    | 299,998        |

### Complexity Validation

| Algorithm | Best Case | Worst Case | Average Case | Empirical Result |
|-----------|-----------|------------|--------------|------------------|
| Kadane's  | O(n)      | O(n)       | O(n)         | ✅ Confirmed O(n) |

### Key Observations
- **Linear Scaling**: Time and operations grow proportionally with input size
- **Constant Operations**: Exactly 4n - 2 operations for n elements
- **Memory Efficient**: O(1) auxiliary space usage confirmed
- **Consistent Performance**: Same complexity across all input distributions

## Algorithm Implementation

### Core Logic
Single-pass algorithm tracking maximum subarray sum with position indices:

```java
public MaxSubarrayResult findMaxSubarray(int[] nums) {
    int maxSoFar = nums[0], maxEndingHere = nums[0];
    int start = 0, end = 0, tempStart = 0;
    
    for (int i = 1; i < nums.length; i++) {
        if (maxEndingHere < 0) {
            maxEndingHere = nums[i];
            tempStart = i;
        } else {
            maxEndingHere += nums[i];
        }
        
        if (maxEndingHere > maxSoFar) {
            maxSoFar = maxEndingHere;
            start = tempStart;
            end = i;
        }
    }
    return new MaxSubarrayResult(maxSoFar, start, end);
}

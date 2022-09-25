import sys
from itertools import combinations

n = int(sys.stdin.readline())

nums = list()
# 조합
for i in range(1, 11): 
    for comb in combinations(range(0, 10), i): 
        comb = list(comb)
        comb.sort(reverse=True)
        nums.append(int("".join(map(str, comb))))

nums.sort()   # 오름차순

if (len(nums) >= n):
      print(nums[n-1])

else:
      print(-1)

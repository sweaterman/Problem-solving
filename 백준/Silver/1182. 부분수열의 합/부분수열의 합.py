N, S = map(int, input().split())
nums = list(map(int, input().split()))
result = 0
for i in range(1, 2**N):
    tmp = 0
    for j in range(N):
        if (i >> j) & 1 == 1:
            tmp += nums[N-1-j]
    if tmp == S:
        result += 1

print(result)
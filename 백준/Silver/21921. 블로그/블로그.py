N, X = map(int, input().split())
today = list(map(int, input().split()))

result = [0] * N
result[0] = today[0]
for i in range(1, N):
    result[i] = today[i] + result[i-1]
    if i > X-1:
        result[i] -= today[i-X]

high = max(result)

if high == 0:
    print('SAD')
else:
    print(high)
    print(result.count(high))
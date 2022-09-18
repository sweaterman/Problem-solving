import sys
input = sys.stdin.readline

N, K = map(int, input().split())
h = list(map(int, input().split()))
h.sort()

costs = [] # 차이 값 계산
for i in range(N-1):
    costs.append(h[i+1]-h[i])
costs.sort(reverse=True)

print(sum(costs[K-1:])) 
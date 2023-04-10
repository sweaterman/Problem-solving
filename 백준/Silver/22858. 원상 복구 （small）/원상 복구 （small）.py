# 카드의 개수 N, 섞은 횟수 K
N, K = map(int, input().split())

# 카드를 섞은 후의 배치
after = list(map(int, input().split()))

# D들
ds = list(map(int, input().split()))

for i in range(K):
    tmp = [0] * N
    for j in range(N):
        tmp[ds[j]-1] = after[j]
    after = tmp.copy()

for i in range(N):
    print(after[i], end=' ')
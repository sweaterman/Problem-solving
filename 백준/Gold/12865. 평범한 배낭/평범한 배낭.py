# 1. 입력 받기
N, K = map(int, input().split())
WV = [[0,0]]
for i in range(N):
    WV.append(list(map(int, input().split())))

# 2. 계산
bag = [[0]*(K+1) for _ in range(N+1)]
#bag[i][j]-> i번째 물건까지 봤을 때, 무게가 j인 배낭의 최대 가치

for i in range(1, N+1):
    for j in range(1, K+1):
        w = WV[i][0]
        v = WV[i][1]
        if j<w: #무게가 더 나가면 안 넣음
            bag[i][j] = bag[i-1][j]
        else: # 아니라면, 이전 배낭 그대로가져감 or 빼고 현재물건을 가져감
            bag[i][j] = max(bag[i-1][j], bag[i-1][j-w] + v)

# 3. 출력
print(bag[N][K])
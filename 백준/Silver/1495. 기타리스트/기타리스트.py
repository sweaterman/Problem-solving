#1. 입력 받기
N, S, M = map(int, input().split())
V = list(map(int, input().split()))

#2. 계산
dp = [[0]*(M+1) for _ in range(N+1)]
dp[0][S] = 1
for i in range(1,N+1):
    for j in range(M+1):
        if dp[i-1][j]>0: #j가 음 높이
            if j + V[i-1]<=M:
                dp[i][j+V[i-1]] = 1
            if j - V[i-1]>=0:
                dp[i][j-V[i-1]] = 1
 
result = -1
for i in range(M,-1,-1):
    if dp[N][i]==1:
        result = i
        break

#3. 출력
print(result)

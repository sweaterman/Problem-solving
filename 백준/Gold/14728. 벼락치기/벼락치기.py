# 단원 개수, 총 시간
N, T = map(int, input().split())
li = []

for _ in range(N):
    # 공부 시간, 배점
    tmp_a, tmp_b = map(int, input().split())
    li.append((tmp_a, tmp_b))

dp = [[0] * (T+1) for _ in range(N+1)]

for i in range(1, N+1):
    time, score = li[i-1][0], li[i-1][1]
    for j in range(1, T+1):
        if j < time:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(score+dp[i-1][j-time], dp[i-1][j])

print(dp[N][T])
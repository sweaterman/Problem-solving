# 1. 입력 받기
str1 = " " + input()
str2 = " " + input()

# 2. 계산
dp = [[0] * (len(str1)) for _ in range(len(str2))]
for i in range(1, len(str2)):
      for j in range(1, len(str1)):
            if str2[i] == str1[j]:
                  dp[i][j] = 1 + dp[i - 1][j - 1]
            else:
                  dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

# 3. 출력
print(dp[-1][-1])

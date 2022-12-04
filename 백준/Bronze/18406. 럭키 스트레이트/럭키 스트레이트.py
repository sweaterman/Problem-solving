# 1. 입력받기
N = input()
a, b = 0, 0

# 2. 계산
for i in range(len(N)//2):
  a += int(N[i])
for j in range(len(N)//2, len(N)):
  b += int(N[j])

# 3. 출력
print("LUCKY" if a==b else "READY")
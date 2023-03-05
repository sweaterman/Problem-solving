
# 1. 입력 받기
N, A, D = map(int, input().split())
note = list(map(int, input().split()))

result = 0
num = 0
for i in range(N):
    if note[i] == A + (num*D): 
        result += 1
        num += 1
print(result)

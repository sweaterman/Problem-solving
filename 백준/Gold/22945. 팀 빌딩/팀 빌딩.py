import sys
input = sys.stdin.readline

N = int(input())
D = list(map(int, input().split()))

start, end, ans = 0, N-1, 0

while start!=end:
    s = (end-start-1) * min(D[start], D[end])
    if (s > ans):
        ans = s
    if (D[start] < D[end]):
        start += 1
    else:
        end -= 1

print(ans)
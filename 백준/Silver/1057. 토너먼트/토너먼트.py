import math

N,j,s = map(int, input().split())
R = 1

if j>s:
    j, s = s, j

while(True):
    if s%2 == 0 and s == j+1:
        print(R)
        break
    if N%2 == 0:
        N = N/2
    else:
        N = int(N/2) + 1
    j = math.ceil(j/2)
    s = math.ceil(s/2)
    R = R+1
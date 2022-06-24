N, M = map(int, input().split())

L = []
for i in range(1, N+1):
    L.append(i)

lo = input().split()
for i in range(M):
    lo[i] = int(lo[i])

count = 0

while (lo!=[]):
    if lo[0] == L[0]:
        pass
    elif L.index(lo[0]) < len(L)/2:
        #왼쪽으로 이동
        while (L[0]!=lo[0]):
            for j in range(len(L)-1):
                L[j], L[j+1] = L[j+1], L[j]
            count += 1
    else:
        #오른쪽으로 이동
        while (L[0]!=lo[0]):
            for j in range(len(L)-1, 0, -1):
                L[j], L[j-1] = L[j-1], L[j]
            count += 1
    del lo[0]
    del L[0]

print(count)
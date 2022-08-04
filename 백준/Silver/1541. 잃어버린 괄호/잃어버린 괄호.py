a = input().split('-')
sum = 0

if (not a[0].isdigit()): #리스트 첫 번째 항목 더하기
    tmp = a[0].split('+')
    for i in tmp:
        sum += int(i)
else:
    sum += int(a[0])

for i in range(1, len(a)): #나머지 항목 처리
    nn = 0
    if (not a[i].isdigit()):
        tmp = a[i].split('+')
        for j in tmp:
            nn += int(j)
    else:
        nn = int(a[i])
    sum -= nn
print(sum)
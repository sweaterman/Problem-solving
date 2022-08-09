n = int(input())
for tc in range(n):
    check = input()
    sum = 0
    tmp = check.split('X')
    for i in tmp:
        if len(i) > 0:
            for j in range(len(i)):
                sum += j+1
    print(sum)
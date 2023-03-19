A, B = map(int, input().split())
result = 0

def find(x):
    global result

    if x > B:
        return
    elif A <= x <= B:
        result += 1

    tmp1 = str(x) + str(4)
    find(int(tmp1))
    tmp2 = str(x) + str(7)
    find(int(tmp2))

find(4)
find(7)

print(result)
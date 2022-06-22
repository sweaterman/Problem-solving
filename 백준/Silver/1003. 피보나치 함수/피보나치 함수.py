T = int(input())

for i in range(T):
    x = int(input())
    if x == 0:
        print('1 0')
    elif x == 1:
        print('0 1')
    else:
        zero = 1
        one = 1
        for j in range(1, x-1):
            zero, one = one, zero+one
        print(f'{zero} {one}')
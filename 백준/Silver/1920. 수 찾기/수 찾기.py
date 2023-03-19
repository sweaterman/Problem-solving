N = int(input())
li1 = list(map(int, input().split()))
M = int(input())
li2 = list(map(int, input().split()))
li1.sort()

def bin(x):
    start = 0
    end = len(li1) - 1
    while start <= end:
        mid = (start+end)//2
        if li1[mid] == x:
            return True
        elif li1[mid] < x:
            start = mid + 1
        else:
            end = mid - 1
    return False

for x in li2:
    if bin(x):
        print(1)
    else:
        print(0)
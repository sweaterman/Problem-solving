import sys
input = sys.stdin.readline

def right_bin(left, right):
    while True:
        mid = int((right+left)/2)
        if line[mid] > B and line[mid-1] <= B:
            return mid
        if line[mid] == B:
            return mid+1
        elif line[mid] < B:
            left = mid+1        
        else:
            right = mid

def left_bin(left, right):
    while True:
        mid = int((right+left)/2)
        if line[mid] < A and line[mid+1] >= A:
            return mid
        if line[mid] == A:
            return mid-1
        if line[mid] < A:
            left = mid+1
        else:
            right = mid
            

N, M = map(int, input().split())
line = [0]
n = list(map(int, input().split()))
for i in range(N):
    line.append(n[i])
line.append(1000000000)
line.sort()

for _ in range(M):
    A, B = map(int, input().split())
    r = right_bin(0, len(line)-1)
    l = left_bin(0, len(line)-1)
    print(r-l-1)

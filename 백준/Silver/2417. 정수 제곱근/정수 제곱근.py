N = int(input())
start = 0
end = N
while start <= end:
    mid = (start + end) // 2
    tmp = mid ** 2
    if tmp < N:
        start = mid+1
    else:
        end = mid-1

print(start)
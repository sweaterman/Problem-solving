import sys
input = sys.stdin.readline

def twoPointer(arr, n, d, k, c):
    start = 0
    end = 0
    check = [0] * 5000
    check[arr[start]] += 1
    check[c] += 1
    cnt = 1
    if arr[start] != c: #시작지점 초밥과 쿠폰의 초밥이 다르면?
        cnt += 1
    ans = 0
    while True:
        end = (end + 1) % n
        check[arr[end]] += 1
        if check[arr[end]] == 1: #안먹은초밥이면?
            cnt += 1

        if (end - start + n) % n == k: #k개 다먹었을 때
            check[arr[start]] -= 1
            if check[arr[start]] == 0:
                cnt -= 1

            start = (start + 1) % n
            if ans < cnt:
                ans = cnt
        if start == n-1: #다 돌면 탈출
            break
    return ans

n, d, k, c = map(int, input().split())
arr = [int(input()) for _ in range(n)]

if n == k:
    ansList = set(arr)
    ansList.add(c)
    print(len(ansList))
else:
    print(twoPointer(arr, n, d, k, c))

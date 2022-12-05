# 1. 입력 받기
N = int(input()) #보드의 크기
K = int(input()) #사과 갯수
board = [[0]*N for _ in range(N)]
for i in range(K):
    a, b = map(int, input().split())
    board[a-1][b-1] = 1
L = int(input())
change = []
for i in range(L):
    a, b = input().split()
    change.append([int(a), b])

# 2. 필요한 값 저장
board[0][0] = 2
direction = [0, 1, 2, 3] #우 하 서 상
front = [[0, 1], [1, 0], [0, -1], [-1, 0]] #직진
x, y, way = 0, 0, 0
second = 0
index = 0
check_change = True
tail_x, tail_y = 0, 0
tail_stack = [[0]*N for _ in range(N)]

# 3. 계산
while True:
    #시간 증가
    second += 1

    tail_stack[x][y] = way
    x += front[way][0]
    y += front[way][1]

    # 3-1. 종료조건
    if x < 0 or x >= N or y < 0 or y >= N or board[x][y] == 2:
        break

    # 3-2. 사과가 없는 칸 도착
    if board[x][y] == 0:
        board[x][y] = 2
        board[tail_x][tail_y] = 0
        tail_way = tail_stack[tail_x][tail_y]
        tail_x += front[tail_way][0]
        tail_y += front[tail_way][1]

    # 3-3. 사과가 있는 칸 도착
    if board[x][y] == 1:
        board[x][y] = 2

    #방향 회전하기
    if check_change and second == change[index][0]:
        if change[index][1] == 'L':
            way -= 1
            if way == -1:
                way = 3
        else:
            way += 1
            if way == 4:
                way = 0
        index += 1
        if index >= len(change):
            index = -1
            check_change = False


print(second)
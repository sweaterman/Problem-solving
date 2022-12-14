from collections import deque
import copy

def bfs(w1, w2, w3):
    gido_copy = copy.deepcopy(gido)
    gido_copy[w1[0]][w1[1]], gido_copy[w2[0]][w2[1]], gido_copy[w3[0]][w3[1]] = 1, 1, 1
    visit = [[False]*M for _ in range(N)]
    queue = deque()
    for x, y in virus:
        queue.append((x, y))

    while queue:
        a, b = queue.popleft()
        if not visit[a][b]:
            visit[a][b] = True
            for d in range(4):
                dx = a + delta[d][0]
                dy = b + delta[d][1]
                if 0 <= dx < N and 0 <= dy < M and gido_copy[dx][dy] == 0:
                    gido_copy[dx][dy] = 2
                    queue.append((dx, dy))
    m = 0
    for i in range(N):
        for j in range(M):
            if gido_copy[i][j] == 0:
                m += 1
    return m


# 1. 입력 받고 바이러스, 벽 아닌곳 위치 저장
N, M = map(int, input().split())
gido = []
notWall = []
delta = [[-1, 0], [1, 0], [0, -1], [0, 1]]
virus = []
for i in range(N):
    h = list(map(int, input().split()))
    gido.append(h)
    for j in range(M):
        if h[j] == 0:
            notWall.append((i, j))
        elif h[j] == 2:
            virus.append((i, j))

# 2. 벽 3개를 선택하는 모든 경우의 수
result = 0
for wall1 in range(len(notWall)):
    for wall2 in range(wall1+1, len(notWall)):
        for wall3 in range(wall2+1, len(notWall)):
            x = bfs(notWall[wall1], notWall[wall2], notWall[wall3])
            if x > result:
                result = x

# 5. 출력
print(result)

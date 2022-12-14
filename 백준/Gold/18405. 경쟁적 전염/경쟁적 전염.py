from collections import deque

def bfs(s, X, Y):
    q = deque(virus)
    count = 0
    while q:
        if count == s:
            break
        for _ in range(len(q)):
            prev, x, y = q.popleft()
            for i in range(4):
                nx = x + delta[i][0]
                ny = y + delta[i][1]
                if 0 <= nx < N and 0 <= ny < N:
                    if graph[nx][ny] == 0:
                        graph[nx][ny] = graph[x][y]
                        q.append((graph[nx][ny], nx, ny))
        count += 1
    return graph[X - 1][Y - 1]

#1. 입력받기
N, K = map(int, input().split())
graph = []
virus = []
for i in range(N):
    graph.append(list(map(int, input().split())))
    for j in range(N):
        if graph[i][j] != 0:
            virus.append(((graph[i][j], i, j)))
S, X, Y = map(int, input().split())
delta = [[-1, 0], [1, 0], [0, -1], [0, 1]]
virus.sort()
print(bfs(S, X, Y))
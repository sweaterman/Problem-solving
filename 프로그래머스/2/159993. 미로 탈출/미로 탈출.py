from collections import deque

def solution(maps):
    def bfs(ax, ay, bx, by):
        visit = [[0] * ry for _ in range(rx)]
        
        q = deque()
        q.append([ax, ay])

        while q:
            tmp = q.popleft()
            for d in delta:
                nx = tmp[0] + d[0]
                ny = tmp[1] + d[1]

                # 인덱스 검사 & 벽 검사 & 방문 검사
                if 0 <= nx < rx and 0 <= ny < ry and maps[nx][ny] != 'X' and not visit[nx][ny]:
                    visit[nx][ny] = visit[tmp[0]][tmp[1]] + 1
                    q.append([nx, ny])
        return visit[bx][by]
        
    rx = len(maps)
    ry = len(maps[0])
    
    for i in range(rx):
        for j in range(ry):
            if maps[i][j] == 'S':
                sx, sy = i, j
            elif maps[i][j] == 'E':
                ex, ey = i, j
            elif maps[i][j] == 'L':
                lx, ly = i, j
    delta = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    t1 = bfs(sx, sy, lx, ly)
    if t1 == 0:
        return -1
    t2 = bfs(lx, ly, ex, ey)
    if t2 == 0:
        return -1
    return t1 + t2
        
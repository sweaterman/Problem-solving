from collections import deque

def solution(maps):
    answer = []
    
    lx, ly = len(maps), len(maps[0])
    visit = [[False]* ly for _ in range(lx)]
    delta = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    
    q = deque()
    for i in range(lx):
        for j in range(ly):
            if maps[i][j] != 'X' and not visit[i][j]:
                visit[i][j] = True
                q.append((i, j))
                value = int(maps[i][j])
                
                while q:
                    tmp = q.pop()
                    for d in delta:
                        nx, ny = tmp[0] + d[0], tmp[1] + d[1]
                        if 0 <= nx < lx and 0 <= ny < ly and not visit[nx][ny] and maps[nx][ny] != 'X':
                            visit[nx][ny] = True
                            value += int(maps[nx][ny])
                            q.append((nx, ny))
                answer.append(value)
    
    answer.sort()
    return answer if answer else [-1]
                
                
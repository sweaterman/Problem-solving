from collections import deque

def solution(land):
    lx, ly = len(land), len(land[0])
    visit = [[False] * ly for _ in range(lx)]
    delta = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    s = [0] * ly

    
    for i in range(lx):
        for j in range(ly):
            if land[i][j] == 1 and not visit[i][j]:
                visit[i][j] = True
                q = deque()
                q.append((i, j))
                check = 1
                li = [j]
                
                while q:
                    tmp = q.popleft()
                    for d in delta:
                        nx, ny = tmp[0] + d[0], tmp[1] + d[1]
                        if 0 <= nx < lx and 0 <= ny < ly and land[nx][ny] == 1 and not visit[nx][ny]:
                            visit[nx][ny] = True
                            check += 1
                            li.append(ny)
                            q.append((nx, ny))
                
                li = set(li)
                li = list(li)
                for l in li:
                    s[l] += check
    
    return max(s)
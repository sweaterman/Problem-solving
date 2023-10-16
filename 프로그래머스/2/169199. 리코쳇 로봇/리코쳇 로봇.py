from collections import deque

def solution(board):
    len_x, len_y = len(board), len(board[0])
    
    # 시작지점, 골 지점 찾기
    s_x, s_y, g_x, g_y = 0, 0, 0, 0
    for i in range(len_x):
        for j in range(len_y):
            if board[i][j] == 'R':
                s_x, s_y = i, j
            elif board[i][j] == 'G':
                g_x, g_y = i, j
                
    visit = [[-1] * len_y for _ in range(len_x)]
    visit[s_x][s_y] = 0
    delta = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    q = deque()
    q.append((s_x, s_y))
    
    # 이동함수
    def check_move(x, y, d):
        next_x, next_y = x, y
        while True:
            if next_x + delta[d][0] < 0 or next_x + delta[d][0] >= len_x or next_y + delta[d][1] < 0 or next_y + delta[d][1] >= len_y:
                break
            if board[next_x + delta[d][0]][next_y + delta[d][1]] == 'D':
                break
            next_x += delta[d][0]
            next_y += delta[d][1]
        
        if visit[next_x][next_y] == -1 or (visit[next_x][next_y] != -1 and visit[next_x][next_y] > visit[x][y] + 1):
            visit[next_x][next_y] = visit[x][y] + 1
            if board[next_x][next_y] != 'G':
                q.append((next_x,next_y))
        
            
    while q:
        x, y = q.popleft()
        for d in range(4):
            check_move(x, y, d)
    
    return visit[g_x][g_y]
def solution(board):
    no, nx = 0, 0

    for i in board:
        for j in i:
            if j == 'O':
                no += 1
            elif j == 'X':
                nx += 1

    if nx > no or no > nx + 1:
        return 0
    
    o, x = False, False
    if no > nx:
        o = True
    else:
        x = True
        
    # 가로
    for i in board:
        if i[0] != '.' and i[0] == i[1] and i[0] == i[2]:
            if i[0] == 'O' and x:
                return 0
            elif i[0] == 'X' and o:
                return 0
    
    # 세로
    for i in range(3):
        if board[0][i] != '.' and board[0][i] == board[1][i] and board[0][i] == board[2][i]:
            if board[0][i] == 'O' and x:
                return 0
            elif board[0][i] == 'X' and o:
                return 0
    
    # 대각선
    if board[0][0] != '.' and board[0][0] == board[1][1] and board[0][0] == board[2][2]:
        if board[0][0] == 'O' and x:
            return 0
        elif board[0][0] == 'X' and o:
            return 0
    if board[2][0] != '.' and board[2][0] == board[1][1] and board[2][0] == board[0][2]:
        if board[2][0] == 'O' and x:
            return 0
        elif board[2][0] == 'X' and o:
            return 0
    
    return 1
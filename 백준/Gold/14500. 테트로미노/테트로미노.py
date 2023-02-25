import sys
input = sys.stdin.readline

#dfs 함수
def dfs(x, y, stack, sum):
    global result

    if stack == 4:
        result = max(sum, result)
        return

    # 4방향 더 가보기
    for i in range(4):
        a = x + delta[i][0]
        b = y + delta[i][1]
        #인덱스 검사
        if 0 <= a < N and 0 <= b < M and visit[a][b] == 0:
            visit[a][b] = 1
            dfs(a, b, stack+1, sum+gido[a][b])
            visit[a][b] = 0

def fuck(x, y, sum):
    global result

    for i in range(4):
        fuckyou = sum
        for j in range(4):
            if i != j:
                a = x+delta[j][0]
                b = y+delta[j][1]
                if 0 <= a < N and 0 <= b < M:
                    fuckyou += gido[a][b]
        result = max(fuckyou, result)

# 1. 입력받기
N, M = map(int, input().split())
gido = []
for _ in range(N):
    input_tmp = list(map(int, input().split()))
    gido.append(input_tmp)

# 2. 필요한 변수 생성
result = 0
delta = [[-1, 0], [1, 0], [0, -1], [0, 1]]
visit = [[0]*M for _ in range(N)]

# 시작점을 정하는 반복문
for root_x in range(N):
    for root_y in range(M):
        visit[root_x][root_y] = 1
        dfs(root_x, root_y, 1, gido[root_x][root_y])
        fuck(root_x, root_y, gido[root_x][root_y])
        visit[root_x][root_y] = 0
print(result)


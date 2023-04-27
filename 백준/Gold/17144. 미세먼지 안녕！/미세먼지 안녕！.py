# R, C => R X C 의 격자판
# T -> T초
R, C, T = map(int, input().split())

# 격자판 입력
pan = []
air = [(-1, -1), (-1, -1)]
for i in range(R):
    pan.append(list(map(int, input().split())))
    if pan[i][0] == -1:
        air[0] = (i-1, 0)
        air[1] = (i, 0)

# 4방향 상하좌우
delta = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def mise():
    # 모두 끝난 후 해당 자리에 더해질 애들
    tmp = [[0]*C for _ in range(R)]

    # 순차적으로 돌면서 계산해놓기
    for i in range(R):
        for j in range(C):
            if pan[i][j] != 0:
                Arc = pan[i][j]
                save = []
                # 인덱스 검사 후, 방향 세기 및 위치 저장
                for k in delta:
                    if 0 <= i+k[0] < R and 0 <= j+k[1] < C:
                        # 공기청정기 위치랑 같으면 확산 X
                        if (air[0][0] == i+k[0] and air[0][1] == j+k[1]) or (air[1][0] == i+k[0] and air[1][1] == j+k[1]):
                            continue
                        save.append([i+k[0], j+k[1]])
                # 확산 시키기
                tmp_plus = int(Arc/5)
                tmp[i][j] -= tmp_plus * len(save)
                for x in save:
                    tmp[x[0]][x[1]] += tmp_plus
    # 끝나기 전에 다 더해주기
    for i in range(R):
        for j in range(C):
            pan[i][j] += tmp[i][j]

def clean():
    # 위쪽 공기청정기
    movingUp = [[0, 1], [-1, 0], [0, -1], [1, 0]]
    tmp_up = [air[0][0], air[0][1]] # 현재 공기청정기 바람 위치
    idxUp = 0
    beforeUp = 0
    while True:
        a = tmp_up[0]+movingUp[idxUp][0]
        b = tmp_up[1]+movingUp[idxUp][1]
        if a == air[0][0] and b == air[0][1]:
            break

        # 바람 흐르기
        elif 0 <= a < R and 0 <= b < C:
            tmp_up = [a, b]
            pan[a][b], beforeUp = beforeUp, pan[a][b]

        # 인덱스 벗어나면 방향 바꾸기
        else:
            if idxUp == 3:
                idxUp = 0
            else:
                idxUp += 1

    # 아래쪽 공기청정기
    movingDown = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    tmp_down = [air[1][0], air[1][1]]
    idxDown = 0
    beforeDown = 0
    while True:
        a = tmp_down[0] + movingDown[idxDown][0]
        b = tmp_down[1] + movingDown[idxDown][1]
        if a == air[1][0] and b == air[1][1]:
            break

        # 바람 흐르기
        elif 0 <= a < R and 0 <= b < C:
            tmp_down = [a, b]
            pan[a][b], beforeDown = beforeDown, pan[a][b]

        # 인덱스 벗어나면 방향 바꾸기
        else:
            if idxDown == 3:
                idxDown = 0
            else:
                idxDown += 1

for i in range(T):
    mise()
    clean()

result = 0
for i in range(R):
    for j in range(C):
        result += pan[i][j]

print(result+2)
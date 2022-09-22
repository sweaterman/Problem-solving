import sys
input = sys.stdin.readline

def cal(idx, tmp):
    global result
    if(idx == 11):
        if(tmp > result):
            result = tmp
        return

    for i in range(11):
        if S[idx][i] != 0 and visit[i] == False:
            visit[i] = True
            cal(idx+1, tmp+S[idx][i])
            visit[i] = False


C = int(input())

for _ in range(C):
    S = []
    visit = [False] * 11
    for i in range(11):
        S.append(list(map(int, input().split())))

    result = 0
    cal(0, 0)

    print(result)
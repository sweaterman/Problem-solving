#부모 찾기
def find_parent(parent, x):
    result = [x]
    while parent[x]:
        result.append(parent[x])
        x = parent[x]
    return result

#1. 입력 받아서 리스트에 저장
T = int(input())
for _ in range(T):
    N = int(input())
    parent = [0 for _ in range(N+1)]
    for _ in range(N-1):
        a, b = map(int, input().split())
        parent[b] = a

    # 2. 각 부모 리스트 정의
    x, y = map(int, input().split())
    x_parent = find_parent(parent, x)
    y_parent = find_parent(parent, y)

    # 3. 깊이 맞춰주기
    i, j = 0, 0
    if len(x_parent) > len(y_parent):
        i = len(x_parent) - len(y_parent)
    else:
        j = len(y_parent) - len(x_parent)

    # 4. 같은 깊이에서 최소 공통 조상 찾기
    while x_parent[i] != y_parent[j]:
        i += 1
        j += 1
    print(x_parent[i])
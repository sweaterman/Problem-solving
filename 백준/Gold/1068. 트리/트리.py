# 트리를 돌면서 삭제해주는 재귀함수 (A는 값)
def deleteNode(tree, A):
    for key, value in tree.items():
        if value == A:
            del(tree[key])
            deleteNode(tree, key)
            deleteNode(tree, A)
            break


# 1. 입력받고 리스트에 노드 저장
n = int(input())
t = list(map(int, input().split()))

# 2. 딕셔너리에 키를 노드값으로, 값을 부모노드로 입력
tree={}
for i in range(n):
    tree[i] = t[i]

# 4. 트리를 돌면서 삭제한 노드를 값으로 가지고 있는 노드 삭제 반복
D = int(input())
del(tree[D])
deleteNode(tree, D)

# 5. 자식이 없는 노드의 개수 검사
sum = 0
check = False
keys = tree.keys()
for i in keys:
    for key, val in tree.items():
        if i == val:
            check = True
            break
    if check == False:
        sum += 1
    check = False
print(sum)
            

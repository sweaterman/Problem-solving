from collections import deque

def bfs(data):
  queue = deque(data)
  count=-1
  while queue:
    size = len(queue)
    for _ in range(size):
      z,x,y = queue.popleft()
      check[z][x][y] = True
      for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        nz = z + dz[i]
      
      #토마토 상자 범위(인덱스)를 벗어나면 continue
        if nx < 0 or ny < 0 or nz < 0 or nx > n-1 or ny > m-1 or nz > h-1:
          continue
      
      #토마토 방문상태 확인 후 처리
        if tomato[nz][nx][ny] == 0 and not check[nz][nx][ny]:
          check[nz][nx][ny] = True
          queue.append((nz,nx,ny))
    count += 1
  return count


m,n,h = map(int,input().split())

tomato =[[list(map(int,input().split())) for i in range(n)] for j in range(h)]
check = [[[False]*m for i in range(n)] for j in range(h)]

#delta 배열
dz = [-1,1,0,0,0,0]
dx = [0,0,-1,1,0,0]
dy = [0,0,0,0,-1,1]

#익은 토마토 위치 저장
data = []
for i in range(h):
  for j in range(n):
    for k in range(m):
      if tomato[i][j][k] == 1:
        tomato[i][j][k] = -1
        data.append((i,j,k))
      if tomato[i][j][k] == -1:
        check[i][j][k] = True
ans = bfs(data)

# 토마토가 모두 익었는지 확인 
flag = False
for i in range(h):
  for j in range(n):
    for k in range(m):
      if check[i][j][k] == False:
        flag = True
      
if flag:
  print(-1)
else:
  print(ans)
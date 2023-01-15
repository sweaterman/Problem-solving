import sys
input = sys.stdin.readline

INF = int(1e9) # 10억
n = int(input()) # 도시 개수
m = int(input()) # 버스 개수
graph = [[INF]*(n+1) for _ in range(n+1)]

for i in range(1, n+1):
  for j in range(1, n+1):
    if i==j:
      graph[i][j] = 0

for i in range(m):
  a, b, c = map(int, input().split())
  graph[a][b] = min(c, graph[a][b])

for k in range(1, n+1):
  for a in range(1, n+1):
    for b in range(1, n+1):
      graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

#출력
for i in range(1, n+1):
  for j in range(1, n+1):
    if graph[i][j] == INF:
      print(0, end=' ')
    else:
      print(graph[i][j], end=' ')
  print()
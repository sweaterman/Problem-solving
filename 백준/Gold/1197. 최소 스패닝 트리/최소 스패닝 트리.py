import sys
input = sys.stdin.readline
from heapq import heappop,heappush

V, E = map(int, input().split()) #정점 개수 V, 간선 개수 E
graph = [[] for _ in range(V+1)]

for i in range(E):
    A, B, C = map(int, input().split())
    graph[A].append([C, B])
    graph[B].append([C, A])

heap = []
heappush(heap, [0, 1]) #가중치, 정점
visit = set()
result = 0

while len(heap) > 0:
    w, vertex = heappop(heap)
    if vertex not in visit:
        visit.add(vertex)
        result += w
        for i in graph[vertex]:
            if i[1] not in visit:
                heappush(heap, [i[0], i[1]])

print(result)
from queue import PriorityQueue

N = int(input())
que = PriorityQueue()
for i in range(N):
    que.put(int(input()))

result = 0
while True:
    if que.qsize() == 1:
        break
    x = que.get() + que.get()
    result += x
    que.put(x)

print(result)
# 에너지 드링크 수 N
N = int(input())

# 에너지 드링크 리스트
drink = list(map(int, input().split()))
drink.sort()
result = drink[N-1]

for i in range(N-1):
  tmp = drink[i]/2
  result += tmp

print(result)
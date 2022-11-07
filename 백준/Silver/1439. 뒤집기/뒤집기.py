N = input()
check = N[0]
li = []

for i in range(1, len(N)):
	if (check != N[i]):
		li.append(i)
		check = N[i]

print(len(li)//2+1 if len(li)%2!=0 else len(li)//2)
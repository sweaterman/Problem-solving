N = int(input())
student = []
for i in range(N):
    name, ko, eng, math = input().split()
    student.append((int(ko), int(eng), int(math), name))
student.sort(key=lambda x:(-x[0], x[1], -x[2], x[3]))

for i in range(N):
    print(student[i][3])
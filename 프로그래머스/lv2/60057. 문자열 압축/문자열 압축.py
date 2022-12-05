# n개 단위로 잘라서 압축
def check_r(s, n):
    start, end = n, n+n
    result = len(s)
    stack = 0
    s1 = s[0:n]
    while True:
        s2 = s[start:end]
        if s1==s2: 
            stack += 1
        else: 
            s1 = s2
            if stack > 0:
                result += len(str(stack))
                result -= stack*n
                stack = 0
        start, end = start+n, end+n

        if end > len(s):
            if stack > 0:
                result += len(str(stack))
                result -= stack*n
            break
    return result

def solution(s):
    answer = len(s)
    for i in range(1, len(s)//2+2):
        tmp = check_r(s, i)
        if tmp < answer:
            answer = tmp
    return answer
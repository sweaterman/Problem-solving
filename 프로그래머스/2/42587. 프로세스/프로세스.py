from collections import deque
def solution(pri, loc):        
    q = deque()
    for i in range(len(pri)):
	    q.append([pri[i], i])
    idx = 0
    while True:
        idx += 1
        tmp = q.popleft()
        flag = False
        for i in range(len(q)):
            if tmp[0] < q[i][0]:
                flag = True
                break
        if flag:
            q.append(tmp)
            idx -= 1
        else:
            if tmp[1] == loc:
                return idx
def solution(plans):
    # 과제 -> 시작시간에 시작
    # 새 과제시간? -> 하던거 멈추고 새거 시작
    # 끝내면 -> 멈춘거 먼저하기. 새로운시각이면 새로운거하기
    # 멈춘게 여러개? -> 최근에 멈춘거 먼저하기
    
    #모든 시간을 단순 분으로 환산. ex) 02:30? -> 150
    for p in plans:
        time = int(p[1][0:2]) * 60 + int(p[1][3:])
        p[1] = time
        p[2] = int(p[2])
    plans = sorted(plans, key = lambda x: x[1])
    
    print(plans)
    
    answer = []
    stop = []
    idx = 0
    time = plans[0][1]
    
    for p in range(len(plans)):
        # 멈춘 과제를 할 시간이 있다
        t = plans[p][1]-time
        while t > 0:
            if stop:
                tmp = stop[len(stop)-1]
                if tmp[1] <= t:
                    answer.append(tmp[0])
                    stop.pop(len(stop)-1)
                    t -= tmp[1]
                else:
                    stop[len(stop)-1][1] -= t
                    break
            else:
                break
        time = plans[p][1]
        # 해당 과제 시간이 되었다
        time += plans[p][2]
        if p+1 < len(plans) and time > plans[p+1][1]:
            stop.append([plans[p][0], time-plans[p+1][1]])
            time = plans[p+1][1]
        else:
            answer.append(plans[p][0])
    
    # 멈춘 과제가 남았다면?
    for i in range(len(stop)-1, -1, -1):
        answer.append(stop[i][0])
        
    return answer
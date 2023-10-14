def solution(picks, minerals):
    
    global answer 
    answer = 987654321

    a = [0, 0, 0]

    def check_p(tmp, piro, s, e):
        global answer
        if tmp == picks or s >= len(minerals):
            if answer > piro:
                answer = piro
        else:
            choice_pick(tmp, piro, s, e)
            
        
    def choice_pick(tmp, piro, s, e):
        for i in range(3):
            if tmp[i]+1 > picks[i]:
                continue
            tmp[i] += 1
            tmp_piro = piro
            for j in range(s, e):
                if j == len(minerals):
                    break
                if minerals[j] == 'diamond':
                    if i == 0:
                        tmp_piro += 1
                    elif i == 1:
                        tmp_piro += 5
                    else:
                        tmp_piro += 25
                elif minerals[j] == 'iron':
                    if i == 2:
                        tmp_piro += 5
                    else:
                        tmp_piro += 1
                else:
                    tmp_piro += 1

            check_p(tmp, tmp_piro, s+5, e+5)
            tmp[i] -= 1
            
    choice_pick(a, 0, 0, 5)
    
    return answer
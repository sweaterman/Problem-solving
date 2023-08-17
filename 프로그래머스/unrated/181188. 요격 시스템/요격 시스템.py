def solution(targets):
    targets.sort()
    result = 0
    check = 0
    
    for t in targets:
        # 불가능
        if check <= t[0]:
            result += 1
            check = t[1]
        # 가능
        else:
            check = min(check, t[1])
    
    return result
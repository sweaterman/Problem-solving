def solution(k, tangerine):
    answer = 0
    
    tangerine.sort()
    arr = [[1, tangerine[0]]]
    
    for i in range(1, len(tangerine)):
        if arr[len(arr)-1][1] == tangerine[i]:
            arr[len(arr)-1][0] += 1
        else:
            arr.append([1, tangerine[i]])
    
    arr.sort(reverse = True)
    
    idx = 0
    while k > 0:
        k -= arr[idx][0]
        answer += 1
        idx += 1
    
    return answer
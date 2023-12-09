def solution(numbers):
    answer = [-1] * len(numbers)
    li = []
    
    for n in range(len(numbers)):
        while li:
            tmp = li.pop()
            if tmp[0] < numbers[n]:
                answer[tmp[1]] = numbers[n]
            else:
                li.append(tmp)
                break
            
        li.append((numbers[n], n))
    
    return answer
def solution(sequence, k):
    answer = []
    
    #투포인터 활용
    start, end = 0, -1
    total = 0
    
    while True:
        if total <= k:
            if total == k:
                if answer:
                    if answer[1] - answer[0] > end - start:
                        answer[0], answer[1] = start, end
                else:
                    answer.append(start)
                    answer.append(end)
            end += 1
            if end >= len(sequence):
                break
            total += sequence[end]
        else:
            total -= sequence[start]
            start += 1
            if start > end:
                break
    
    return answer
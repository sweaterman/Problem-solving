def solution(sequence, k):
    answer = []
    
    #투포인터 활용
    start, end = 0, -1
    total = 0
    
    while True:
        # 만약, total 값이 k보다 작거나 같을 때
        if total <= k:
            # 같을 때, answer의 값과 비교해서 넣어주거나, 안넣거나
            if total == k:
                if answer:
                    if answer[1] - answer[0] > end - start:
                        answer[0], answer[1] = start, end
                else:
                    answer.append(start)
                    answer.append(end)
            # 작거나 같을 때, end를 뒤로 한칸 밀어주고 다시 계산
            end += 1
            # 인덱스가 초과하면 반복문 종료
            if end >= len(sequence):
                break
            total += sequence[end]
        # 만약, total 값이 k보다 클 때
        else:
            # start 값을 뒤로 한칸 밀어주고 계산
            total -= sequence[start]
            start += 1
            # start 값이 end 값보다 넘어가면 반복문 종료
            if start > end:
                break
    
    return answer
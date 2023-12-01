import heapq

def solution(book_time):
    answer = 0
    
    for i in range(len(book_time)):
        a = int(book_time[i][0][0:2]) * 60 + int(book_time[i][0][3:])
        b = int(book_time[i][1][0:2]) * 60 + int(book_time[i][1][3:])
        book_time[i] = (a, b)
    
    book_time.sort()
    
    q = []
    for i in book_time:
        if q and q[0]+10 <= i[0]:
            heapq.heappop(q)
        else:
            answer += 1
        heapq.heappush(q, i[1])

    return answer
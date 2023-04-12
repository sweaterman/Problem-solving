def solution(arr):
    li = []
    li.append(arr[0])
    idx = 0
    for i in range(1, len(arr)):
        if (li[idx] != arr[i]):
            li.append(arr[i])
            idx += 1
    return li
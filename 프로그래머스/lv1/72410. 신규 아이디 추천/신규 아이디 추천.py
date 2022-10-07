def solution(new_id):
    #1
    new_id = list(new_id.lower())

    #2
    i = 0
    while i != len(new_id):
        if new_id[i].isalnum() or new_id[i] == '-' or new_id[i] == '_' or new_id[i] == '.':
            i += 1
            continue
        else:
            del new_id[i]

    #3
    i = 0
    flag = True
    while i != len(new_id):
        if new_id[i] == '.':
            if flag:
                flag = False
                i += 1
            else:
                del new_id[i]
        else:
            flag = True
            i += 1

    #4
    if len(new_id) >= 1 and new_id[len(new_id)-1] == '.': del new_id[len(new_id)-1]
    if len(new_id) >= 1 and new_id[0] == '.': del new_id[0]

    #5
    if len(new_id) == 0: new_id = ['a']

    #6
    if len(new_id) >= 16: new_id = new_id[:15]
    if new_id[len(new_id)-1] == '.': del new_id[len(new_id)-1]
    
    #7
    if len(new_id) <= 2:
        plus = new_id[len(new_id)-1]
        while len(new_id) != 3:
            new_id.append(plus)
 
    answer = "".join(new_id)
    return answer
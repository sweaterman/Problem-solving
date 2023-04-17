def solution(phone_book):
    phone_book.sort() 
    num = 0
    for i in range(1, len(phone_book)):
        if phone_book[num] == phone_book[i][:len(phone_book[num])]:
            return False
        else:
            num = i
    return True
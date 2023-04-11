def solution(nums):
    # 1. 가질 수 있는 폰켓몬 수
    N = len(nums) // 2
    # 2. 중복 제거
    nums = set(nums)
    
    if (len(nums)  >= N):
        return N
    else:
        return len(nums)
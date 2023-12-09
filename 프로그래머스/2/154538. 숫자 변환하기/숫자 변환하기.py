def solution(x, y, n):
    
    nums = [987654321] * (y+1)
    nums[x] = 0
    if x + n <= y:
        nums[x+n] = 1
    if x*2 <= y:
        nums[x*2] = 1
    if x*3 <= y:
        nums[x*3] = 1
    
    for i in range(x, y+1):
        if nums[i] != 987654321:
            if i + n <= y:
                nums[i+n] = min(nums[i]+1, nums[i+n])
            if i*2 <= y:
                nums[i*2] = min(nums[i]+1, nums[i*2])
            if i*3 <= y:
                nums[i*3] = min(nums[i]+1, nums[i*3])
    
    return nums[y] if nums[y] != 987654321 else -1
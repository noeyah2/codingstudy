def solution(name):
    n = len(name)
    ans = 0

    for ch in name:
        ans += min(ord(ch) - 65, 90 - ord(ch) + 1)

    move = n - 1
    for i in range(n):
        next_idx = i + 1
        
        while next_idx < n and name[next_idx] == 'A':
            next_idx += 1
            
        dist = min(2*i + n - next_idx, i + 2*(n - next_idx))
        move = min(move, dist)
    
    ans += move
    return ans

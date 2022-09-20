# 10808 알파벳 개수
# https://www.acmicpc.net/problem/10808


import sys
arr = sys.stdin.readline().strip()
result = [0]*26

for i in arr:
    result[ord(i) - 97] += 1

print(*result) # * => 약간 js의 rest 문법과 비슷한 느낌..? 
# https://sshkim.tistory.com/182
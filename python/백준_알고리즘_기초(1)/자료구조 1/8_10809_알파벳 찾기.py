# 10809 알파벳 찾기
# https://www.acmicpc.net/problem/10809

import sys

arr = sys.stdin.readline().strip()
result = [-1]*26

for i in range(len(arr)):
    n = ord(arr[i]) - 97
    if result[n] == -1: 
        result[n] = i; 

print(*result)
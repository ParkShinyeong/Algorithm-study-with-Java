# 17298 오큰수
# https://www.acmicpc.net/problem/17298

#! 시간 초과 
# 매번 Ai 를 기준으로 Ai+1부터 N까지 이중 반복문을 돌리므로 O(N^2)의 시간 복잡도가 걸린다. 

# import sys
# n = int(sys.stdin.readline()); 
# arr = sys.stdin.readline().split()
# length = len(arr); 
# for i in range(length):
#     arr[i] = int(arr[i])

# result = []
# result_idx = []; 

# for i in range(length): 
#     ans = -1; 
#     for j in range(i + 1, length): 
#         if arr[i] < arr[j]: 
#             ans = arr[j]; 
#             break; 
#     result_idx.append(j); 
#     result.append(ans); 
    
    
# for i in result:
#     print(i, end=" ")


# ! 시간 초과 X 
import sys
n = int(sys.stdin.readline()); 
arr = sys.stdin.readline().split()
answer = [-1]*n; # 만약 n = 3이면 [-1, -1, -1]
stack = [0]; 


for i in range(n):
    while stack and arr[stack[-1]] < arr[i]: 
        answer[stack.pop()] = arr[i] 
    stack.append(i); 

print(*answer)
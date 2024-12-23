# 10799 쇠막대기
# https://www.acmicpc.net/problem/10799

str = list(input()); 
stack = []
answer = 0; 
prev = -1; 

for i in str: 
    if i == "(":
        stack.append(i); 
    elif i == ")":
        if prev == "(" :
            answer += len(stack) - 1; 
            stack.pop()
        else:
            answer += 1; 
            stack.pop()
    
    prev = i; 

print(answer); 
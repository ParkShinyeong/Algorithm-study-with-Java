# 10828 스택 
# https://www.acmicpc.net/problem/10828

import sys

n = int(sys.stdin.readline())
stack = []; 

for i in range(n): 
    inputValue = sys.stdin.readline().split(); 
    command = inputValue[0]; 
    
    if command == 'push':
        value = inputValue[1]; 
        stack.append(value); 
    elif command == 'pop':
        if len(stack) == 0:
            print(-1); 
        else:
            print(stack.pop())
            
    elif command == 'size': 
        print(len(stack)); 
    
    elif command == 'empty':
        if len(stack) == 0:
            print(1); 
        else: 
            print(0);
    
    elif command == 'top':
        if len(stack) == 0: 
            print(-1); 
        else :
            print(stack[-1])

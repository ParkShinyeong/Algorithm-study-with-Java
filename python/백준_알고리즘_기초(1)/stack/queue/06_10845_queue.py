# 10845번 큐 
# https://www.acmicpc.net/problem/10845

# input보다 sys.stdin.readline() 함수가 시간이 2배는 절약된다. 
import sys 
n = int(input())
queue = []; 

for i in range(n):
    word = sys.stdin.readline().split(); 
    cmd = word[0]; 
    
    if cmd == 'push':
        queue.append(word[1]); 
    elif cmd == 'pop': 
        if len(queue) == 0:
            print(-1); 
        else: 
            print(queue.pop(0)); 
    elif cmd == 'size': 
        print(len(queue))
    elif cmd == 'empty': 
        if len(queue) == 0:
            print(1);
        else: print(0); 
    elif cmd == 'front': 
        if len(queue) == 0: 
            print(-1)
        else: 
            print(queue[0])
    elif cmd == 'back': 
        if len(queue) == 0: 
            print(-1)
        else: 
            print(queue[-1])
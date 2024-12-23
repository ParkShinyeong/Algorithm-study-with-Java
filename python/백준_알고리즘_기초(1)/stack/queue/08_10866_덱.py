# 10866 덱 
# https://www.acmicpc.net/problem/10866

# ? deque란?
# stack이나 queue처럼 한 방향에서 삽입과 삭제가 일어나는 것이 아닌 '양방향'에서 삽입과 삭제가 일어나는 자료구조 
# list는 배열형태이므로 index의 앞부분에서 삽입 삭제가 일어나면 비효율 적이다. 
# 참고 = https://j-ungry.tistory.com/189

import sys; 
from collections import deque

n = int(input()); 
dq = deque(); 

for _ in range(n):
    word = sys.stdin.readline().split()
    cmd = word[0]; 
    if cmd == 'push_back':
        dq.append(word[1])
    elif cmd == 'push_front':
        dq.appendleft(word[1])
    elif cmd == 'pop_front': 
        if dq: 
            print(dq.popleft())
        else:
            print(-1)
    elif cmd == 'pop_back': 
        if dq: 
            print(dq.pop())
        else:
            print(-1)
    elif cmd == 'size':
        print(len(dq)) 
    elif cmd == 'empty':  
        if dq: 
            print(0)
        else: print(1); 
    elif cmd == 'front':
        if dq:
            print(dq[0])
        else: 
            print(-1)
    elif cmd == 'back':
        if dq:
            print(dq[-1])
        else: print(-1) 
    


# ! 내가 작성한 코드..
# import sys; 

# n = int(input()); 
# deque = []; 
# deque_l = []; 

# for _ in range(n):
#     word = sys.stdin.readline().split()
#     cmd = word[0]; 
#     if cmd == 'push_back': 
#         deque.append(word[1])
#     elif cmd == 'push_front':
#         deque_l.append(word[1])
#     elif cmd == 'pop_front': 
#         if deque_l: 
#             print(deque_l.pop())
#         elif deque:
#             print(deque.pop(0))
#         else: 
#             print(-1)
#     elif cmd == 'pop_back': 
#         if deque: 
#             print(deque.pop())
#         elif deque_l:
#             print(deque_l.pop(0))
#         else: print(-1)
#     elif cmd == 'size':
#         print(len(deque) + len(deque_l)) 
#     elif cmd == 'empty': 
#         size = len(deque) + len(deque_l); 
#         if size == 0: 
#             print(1)
#         else: print(0); 
#     elif cmd == 'front':
#         if deque_l:
#             print(deque_l[-1]) 
#         elif deque:
#             print(deque[0])
#         else: print(-1)
#     elif cmd == 'back':
#         if deque:
#             print(deque[-1])
#         elif deque_l:
#             print(deque_l[0])
#         else: print(-1) 
    
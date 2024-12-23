# 1874번 스택 수열
# https://www.acmicpc.net/problem/1874

n = int(input())

stack = []; 
result = []; 
cnt = 1; 
tmp = True; 

# ? 입력된 순서대로 수열이 완성되어야 한다. 
for i in range(n):
    num = int(input()); 
    while cnt <= num: # 입력된 수가 나올 때까지 push 해준다. 
        stack.append(cnt); 
        result.append('+'); 
        cnt += 1; 
    if stack[-1] == num: # 입력된 수가 스택 맨 윗부분에 존재하면 pop 해준다. 
        stack.pop(); 
        result.append('-'); 
    else:  # 입력된 수가 스택 맨 윗부분에 존재하지 않을 때 수열이 완성될 수 없다. 
        tmp = False; 

if tmp == False: print("NO")
else: 
    for i in result:
        print(i); 
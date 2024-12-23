# 1406번 에디터 
# https://www.acmicpc.net/problem/1406
# 참고 - https://velog.io/@tkdduf727/%EB%B0%B1%EC%A4%80-%EA%B4%84%ED%98%B8-1406%EB%B2%88-%ED%8C%8C%EC%9D%B4%EC%8D%AC-Python-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0

#? 아래 코드는 시간 초과가 된다. 
#? insert의 시간 복잡도가 O(N)이라고 한다. 
#? append() => O(1), pop() => O(1) 

string = list(input()); 
n = int(input()); 
pos = len(string); 

for i in range(n):
    cmd = input().split()
    op = cmd[0]; 
    if op == 'L' and pos > 0:
        pos -= 1; 
    elif op == 'D' and pos < len(string):
        pos += 1; 
    elif op == 'B' and pos > 0: 
        string.pop(pos - 1); 
    elif op == 'P':
        string.insert(pos, cmd[1])
        pos += 1; 
for i in string:
    print(i, end="")


#! 시간 복잡도를 최소화
import sys 

stack_l = list(input()); # 커서의 왼쪽에 있는 문자 
n = int(input()); 

stack_r = []; # 커서의 오른쪽에 있는 문자 

for i in range(n):
    cmd = sys.stdin.readline().split()
    op = cmd[0]; 
    if op == 'L' and stack_l :
        # 커서를 왼쪽으로 옮기면 커서 오른쪽의 문자를 stack_r에 넣어준다. 
        stack_r.append(stack_l.pop())
    elif op == 'D' and stack_r:
        # 커서를 오른쪽으로 옮기면 왼쪽의 문자를 stack_l로 옮긴다. 
        stack_l.append(stack_r.pop()); 
    elif op == 'B' and stack_l: 
        # 커서 왼쪽의 문자를 하나 삭제한다. stack_l에서 문자 하나를 제거한다. 
        stack_l.pop(); 
    elif op == 'P':
        # 커서의 왼쪽에 문자를 추가하므로 stack_l에 문자를 추가한다. 
        stack_l.append(cmd[1]); 

# stack_r은 문자가 반대로 되어 있으므로 반대로 전환해서 출력한다. 
print("".join(stack_l + list(reversed(stack_r))))

# 9093번 단어 뒤집기 

# 파이썬은 다른 언어와 다르게 stack이 구현되어 있지는 않는다. 

# 대신 자료형 list가 stack 형태로 만들어져 있어 list를 이용해 stack을 사용한다. 
n = int(input())

for i in range(n) :
    str = list(input().split()); 
    print('list', str)
    for j in str: 
        print(j[::-1], end=' ')


# Stack 자료 구조로 풀어보자 
n = int(input())

for i in range(n) :
    str = input(); 
    str += " "
    stack = []; 
    for j in str:
        if j != " ":
            stack.append(j)
        else:
            while stack: 
                print(stack.pop(), end='')
            print(' ', end='')



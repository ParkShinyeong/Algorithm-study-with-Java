# 1935 후위 표기식2
# https://www.acmicpc.net/problem/1935

num = int(input())
word = input()

num_list = [0]*num

for i in range(num):
    num_list[i] = int(input())

stack = []
for i in word:
    if 'A' <= i <= 'Z':
        # 알파벳이 A부터 순서대로 들어온다. 
        stack.append(num_list[ord(i) - ord('A')])
    else: 
        a = stack.pop()
        b = stack.pop()
        if i == '+': 
            stack.append(a + b)
        elif i == '-':
            stack.append(b - a)
        elif i == '/':
            stack.append(b / a)
        elif i == '*':
            stack.append(a * b)

print('%.2f' %stack[0]) # 소수점 2째 자리까지만 출력 
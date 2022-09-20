# 1918 후위 표기식
# https://www.acmicpc.net/problem/1918


from curses.ascii import isalpha
import sys
str = sys.stdin.readline()
stack = []

result = ""; 

for i in str:
    if i.isalpha():
        result += i; 
    elif i == '/' or i == '*':
        while stack and ( stack[-1] == '*' or stack[-1]  '/' ):
            result += stack.pop()
        stack.append(i); 
    elif i == '+' or i == '-':
        while stack and stack[-1] != '(': 
            ans += stack.pop(); 
    # elif i == 

while stack:
    c = stack.pop()

'''
하나의 자연수를 입력받아 각 자릿수의 합을 계산하는 프로그램 

'''

num = int(input())
answer = 0

while num > 0: 
    one = num % 10
    answer += one
    num = num // 10

print(answer)
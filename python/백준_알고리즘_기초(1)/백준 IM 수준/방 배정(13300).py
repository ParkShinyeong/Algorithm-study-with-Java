#13300번 
# https://www.acmicpc.net/problem/13300
import math
# n: 학생 수, k: 최대 배정 인원 
n, k = map(int, input().split(" "))

studentCnt = [[0] * 6, [0] * 6] 
answer = 0; 

for _ in range(n): 
    sex, year = map(int, input().split(" "))
    studentCnt[sex][year - 1] += 1; 

for std in studentCnt:
    for cnt in std:
        if cnt % k == 0:
            answer += cnt // k
        else:
            answer += cnt // k + 1
print(answer); 


# 런타임 에러 
'''
- 입력데이터가 제대로 처리되지 않으면 런타임 에러가 날 가능성이 있음 
students = {}
for i in range(1, 7) :
    students[i] = [0]*2; 
'''

students = {i : [0, 0] for i in range(1, 7)}
    
for _ in range(n):
    s, y = map(int, input().split(" "))
    students[y][s] += 1; 

answer = 0; 
for key in students.keys(): 
    for i in range(2):
        cnt = students[key][i] 
        if cnt % k == 0 : 
            answer += cnt // k
        else:
            answer += (cnt + k - 1) // k  # 올림계산 

print(answer); 


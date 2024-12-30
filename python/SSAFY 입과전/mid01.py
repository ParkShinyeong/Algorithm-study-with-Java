# 두 개의 숫자열
'''
[입력]
- 첫 줄에는 테스트 케이스 개수 T, 그 아래 각 테스트 케이스 주어짐
- 각 테스트 케이스의 첫 번째 줄에 N과 M
- 두 번째 줄에 A
- 세 번째 줄에 B

[출력] 각 줄은 #t로 시작. 공백을 한 칸 둔 다음 다음 정답 출력 
t는 1부터 시작 
'''
import sys 

def maxSum(first, second) : 
    pos = 0; 
    maxValue = -sys.maxsize - 1 # 시스템에서 가장 작은 수 
    while pos <= len(first) - len(second):
        sum = 0; 
        for i in range(len(second)):
            sum += first[i + pos] * second[i]
        pos += 1
        maxValue = max(sum, maxValue); 
    return maxValue; 

T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    answer = 0; 

    if N > M:
        answer = maxSum(A, B)
    else:
        answer = maxSum(B, A)


    print(f"#{test_case} {answer}")


    
        


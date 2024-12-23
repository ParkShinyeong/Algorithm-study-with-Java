# 1158 요세푸스 문제 
# acmicpc.net/problem/1158

#! 정답 
n, k = map(int, input().split())
queue = [i for i in range(1, n + 1)]; 
result = []; 
num = 0; # 제거될 사람의 인덱스 번호 

for i in range(n):
    num += k - 1; 
    print(num, end=" "); 
    if num >= len(queue):
        num = num % len(queue)
    
    answer = str(queue.pop(num)); 
    print(answer, end=" ")
    print(queue)
    result.append(answer)

print("<", ", ".join(result)[:], ">", sep="")

# ! 내가 작성한 코드 => 시간 초과 
#? 더 간단하게 쓸 수 있다. 
# # n, k = input().split()
# # n = int(n)
# # k = int(k)
# n, k = map(int, input().split())
# tmp = k; 

# #? 이 부분도 아래와 같이 간결하게 작성할 수 있다. 
# # queue = []; 
# # for i in range(1, n + 1):
# #      queue.append(i); 
# queue = [i for i in range(1, n + 1)]; 
     
     
# result = []; 

# while len(queue) != 0:
#     tmp -= 1;
#     first = str(queue.pop(0)); 
#     if tmp == 0:
#         tmp = k; 
#         result.append(first); 
#     else :
#         queue.append(first); 

# print("<", ", ".join(result)[:], ">", sep="")

# # 파이썬의 join
# # `"구분자".join(리스트)` 형태로 사용한다. 
# # ex) "_".join([a, b, c]) => 'a_b_c' 
# # 다만 리스트 내부에 

# #? print option
# # sep => 구분자 
# # end => 그 뒤의 출력 값과 이어서 출력해준다 .=> 줄바꿈을 하지 않는다. 
# # 참고 => https://infinitt.tistory.com/11
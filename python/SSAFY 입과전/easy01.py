

'''
가위바위보 
가위 = 1
바위 = 2
보 = 3
A와 B중에 누가 이겼는지 출력

1 < 2 / 2 < 3 / 3 < 1


'''
A, B = map(int, input().split())
condition = (B > A and B < 3) or (A == 3 and B == 1)
answer = "B" if condition else "A"
print(answer)

# # B가 이기는 경우 
# if (B > A and B < 3) or (A == 3 and B == 1):
#     answer = "B"

# print(answer)
    
        

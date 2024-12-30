# 중간값 찾기 

n = int(input())
numList = list(map(int, input().split())) 

numList.sort(); 
mid = n // 2
print(numList[mid])
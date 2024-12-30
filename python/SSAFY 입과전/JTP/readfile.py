f = open("python/SSAFY 입과전/JTP/new.txt", "r", encoding="UTF-8")
# while True: 
#     line = f.readline() #  한 줄 읽기 
#     if not line:
#         break; 
#     print(line, end="")

# lines = f.readlines()  #  모든 줄을 리스트로 담아 리턴 
# for line in lines:
#     print(line, end="");  
#     # 혹은 line.strip()으로 줄바꿈 문자 제거 가능 

file = f.read()
print(file); 
f.close()
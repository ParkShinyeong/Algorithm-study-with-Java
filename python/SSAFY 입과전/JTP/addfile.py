f = open("python/SSAFY 입과전/JTP/new.txt", "a", encoding="UTF-8")

for i in range(11, 20): 
    data = f"{i}번째 줄입니다.\n"
    f.write(data)
f.close()
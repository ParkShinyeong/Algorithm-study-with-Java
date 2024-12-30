f = open("python/SSAFY 입과전/JTP/new.txt", 'w', encoding="UTF-8")
for i in range(10):
    data = f"{i + 1}번째 줄입니다. \n"
    f.write(data); 
f.close(); 
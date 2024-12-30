with open("python/SSAFY 입과전/JTP/withNew.txt", "w", encoding="UTF-8") as f:
    for num in range(1, 11): 
        f.write(f"{num}번 학생은 합격입니다\n")

# with을 쓰면 open과 close를 자동으로 처리해준다. 
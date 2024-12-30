
def plusShape(board, x, y, n, m) :
    total = 0;
    total += sum(board[x][max(0, y - m + 1) : min(n, y + m)]) # 가로 행 더하기 
    for i in range(max(0, x - m + 1), min(n, x + m)):
        total += board[i][y]
    total -= board[x][y]; 
    return total; 
     
def xShape(board, x, y, n, m) :
    total = board[x][y];
    for i in range(1, m):
        if x + i >= n or x - i < 0 or y + i >= n or y - i < 0:
            continue; 
        total += board[x + i][y + i] + board[x - i][y + i] + board[x + i][y - i] + board[x - i][y - i]
    return total; 


T = int(input())

for test_case in range(1, T + 1): 
    n, m = map(int, input().split(" "))
    board = [] 
    for i in range(n): 
        board.append(list(map(int, input().split()))); 
    maxValue = 0;

    for i in range(n):
        for j in range(n): 
            plus = plusShape(board, i, j, n, m)
            multi = xShape(board, i, j, n, m)
            maxValue = max(maxValue, plus, multi)
    print(f"#{test_case} {maxValue}")




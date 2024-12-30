# 숫자 배열 회전

'''
[입력]
첫줄 - 테스트 케이스 개수 T
N
N*N행렬 
'''
def rotate90(N, board) :
    newBoard = [[0] * N for i in range(N)] 
    for i in range(N):
        for j in range(N): 
            newBoard[i][j] = str(board[N - 1 - j][i])
    return newBoard; 

T = int(input())

for test_case in range(1, T + 1):
    # 입력값 받기 
    N = int(input())
    board = []
    for i in range(N):
        board.append(list(map(int, input().split(" ")))); 
    
    # 배열 회전하기 
    degree90 = rotate90(N, board)
    degree180 = rotate90(N, degree90)
    degree270 = rotate90(N, degree180)

    # 출력
    print(f"#{test_case}")
    for i in range(N):
        print("".join(degree90[i]), end=" ")
        print("".join(degree180[i]), end=" ")
        print("".join(degree270[i]), end=" ")
        print()

    
    # 파이썬 리스트 초기화 
    '''
    1. board = [0] * N
    2. (리스트 컴프리핸션) board = [0 for i in range(N)]

    이중 배열 [[0] * 4] * 4  이 딴식으로 하지 말자 - 내부 배열의 참조값이 다 같음 
    '''



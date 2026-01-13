N = int(input())
for i in range(0, N) :
    A, B, X = map(int, input().split())
    print(A * (X - 1) + B)
    
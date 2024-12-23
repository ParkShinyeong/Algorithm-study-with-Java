# 9012번 괄호 
# https://www.acmicpc.net/problem/9012


n = int(input())
for s in range(n):
    string = input(); 
    string = list(string); 
    result = 0;  
    for i in string: 
        if i == '(' :
            result += 1
        elif i == ')':
            result -= 1 
        if result < 0:
            # 음수가 되면 바로 No를 출력해야 한다. 
            # 안그러면 ())(() => YES가 될 수 있다. 
            print('NO'); 
            break; 
            
    if result == 0:
        print("YES")
    elif result > 0: 
        print("NO")

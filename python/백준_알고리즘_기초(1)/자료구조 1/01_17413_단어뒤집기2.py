
str = list(input())
result = []; 
stack = []; 
flag = False; 

for i in str: 
    if i == "<" or i == " ":
        if i == "<":
            flag = True; 
        if stack: 
            while stack:
                result.append(stack.pop())
        result.append(i); 
    elif i == ">":
        flag = False; 
        result.append(i)
    else: 
        if flag == True: 
            result.append(i); 
        else: stack.append(i); 
    


if stack:
    while stack:
        result.append(stack.pop()); 

print("".join(result)); 
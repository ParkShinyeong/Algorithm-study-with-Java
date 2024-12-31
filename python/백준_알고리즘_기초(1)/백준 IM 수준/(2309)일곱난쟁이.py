
dwarf = [int(input()) for _ in range(9)]
dwarf.sort()
total = sum(dwarf)
status = True

for i in range(9):
    for j in range(i + 1, 9):
        sub = total - dwarf[i] - dwarf[j]
        if sub == 100:
            del dwarf[i]; 
            del dwarf[j - 1]; 
            status = False
            break; 
    if not status: break; 

for i in dwarf:
    print(i); 
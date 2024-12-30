class Calculate: 
    def __init__(self, first = 0, second = 1):
        self.first = first
        self.second = second

    def setData(self, first, second):
        self.first = first
        self.second = second

    def add(self):
        result = self.first + self.second
        return result; 
    def sub(self):
        result = self.first - self.second
        return result; 
    def mul(self):
        result = self.first * self.second
        return result; 
    def div(self):
        result = self.first / self.second
        return result; 


# a = Calculate(10, 2)
a = Calculate()
# a.setData(10, 2)
print(a.add())
print(a.sub())
print(a.mul())
print(a.div())

# 상속 
class MoreCalculate(Calculate): 
    def pow(self):
        result = self.first ** self.second
        return result

mc = MoreCalculate(6, 3); 
print(mc.pow())

class SafeCalculate(Calculate):
    # 메서드 오버라이딩 
    def div(self):
        if(self.second == 0) :
            return 0 # 나누는 값이 0인 경우 0을 리턴하도록 수정 
        else:
            return self.first / self.second;  


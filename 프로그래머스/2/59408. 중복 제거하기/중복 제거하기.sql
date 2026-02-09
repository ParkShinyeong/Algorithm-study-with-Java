-- 코드를 입력하세요
SELECT count(distinct name) 
from animal_ins; 
# count는 원래 Null 값을 무시한다. 
# where name is not null;
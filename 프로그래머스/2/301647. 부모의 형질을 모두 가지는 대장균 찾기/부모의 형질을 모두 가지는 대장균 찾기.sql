-- GENOTYPE을 2진수로 바꾸기 
-- 자식타입과 부모 타입을 조인하기 
-- 자식이 부모의 형질을 모두 포함하는지 체크하기 (자식 & 부모 -> 결과값이 부모와 같은지 확인)
-- 부모의 형질을 모두 보유한 개체 아이디를 오름차순 정렬하기 

SELECT E.ID, E.GENOTYPE, P.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA AS E
JOIN ECOLI_DATA AS P ON E.PARENT_ID = P.ID
WHERE (E.GENOTYPE & P.GENOTYPE = P.GENOTYPE)
ORDER BY E.ID 




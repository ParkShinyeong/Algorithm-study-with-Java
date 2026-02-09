-- 코드를 작성해주세요

# select fi.ID, fni.fish_name as FISH_NAME, LENGTH
# from fish_info as fi 
# join fish_name_info as fni on fi.fish_type = fni.fish_type
# where (fi.fish_type, fi.length) 
# IN ()
# order by length desc

select fi.ID, fni.FISH_NAME, fi.LENGTH
from fish_info as fi
join fish_name_info as fni on fni.fish_type = fi.fish_type
where (fi.fish_type, fi.length) in (
    select fish_type, max(length)
    from fish_info
    group by fish_type);
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, date_format(r.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
FROM USED_GOODS_BOARD as b
JOIN USED_GOODS_REPLY as r ON b.board_id = r.board_id
WHERE year(b.created_date) = 2022 and month(b.created_date) = 10
ORDER BY r.created_date, b.title;
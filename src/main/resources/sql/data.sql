INSERT INTO college (name, created_date, modified_date)
SELECT '한동대학교', now(), now()
WHERE NOT EXISTS (
    SELECT 1 FROM college WHERE name = '한동대학교'
);

INSERT INTO board (title, created_date, modified_date, college_id)
SELECT '자유게시판', now(), now(), 1
WHERE NOT EXISTS (
    SELECT 1 FROM board WHERE title = '자유게시판'
);


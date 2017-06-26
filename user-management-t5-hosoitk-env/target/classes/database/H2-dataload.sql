INSERT INTO
t_user(user_id, username, birthday, address, tel_num, password, status, last_update)
VALUES('0000', 'demo', to_date('2000-12-31 12:00:00','yyyy/mm/dd hh24:mi:ss'), '東京都足立区神明南2-13-6', '99999999999','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'ACT', to_date('2000-12-31 12:00:00','yyyy/mm/dd hh24:mi:ss'));
--,('0001', 'demo1', to_date('2000-12-31 12:00:00','yyyy/mm/dd hh24:mi:ss'), '東京都足立区神明南2-13-6', '99999999999','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'ACT', to_date('2000-12-31 12:00:00','yyyy/mm/dd hh24:mi:ss'))
--,('0002', 'demo2', to_date('2000-12-31 12:00:00','yyyy/mm/dd hh24:mi:ss'), '東京都足立区神明南2-13-6', '99999999999','$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'ACT', to_date('2000-12-31 12:00:00','yyyy/mm/dd hh24:mi:ss'));
COMMIT;
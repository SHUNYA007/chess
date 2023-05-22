ALTER TABLE chess ADD CONSTRAINT players_un UNIQUE KEY (username);

ALTER TABLE chess.players MODIFY COLUMN username varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;


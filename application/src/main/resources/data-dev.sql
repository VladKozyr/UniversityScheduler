SELECT 'test';

INSERT INTO SLOT (ID, DAY, ROOM, TIME)
VALUES (1, 'MONDAY', '228-room', 'FIRST');
INSERT INTO SLOT (ID, DAY, ROOM, TIME)
VALUES (2, 'MONDAY', '228-room', 'SECOND');
INSERT INTO SLOT (ID, DAY, ROOM, TIME)
VALUES (3, 'MONDAY', '228-room', 'THIRD');
INSERT INTO SLOT (ID, DAY, ROOM, TIME)
VALUES (4, 'MONDAY', '228-room', 'FOURTH');
INSERT INTO SLOT (ID, DAY, ROOM, TIME)
VALUES (5, 'MONDAY', '228-room', 'FIFTH');

INSERT INTO COURSE (ID, YEAR, FACULTY)
VALUES (1, 2019, 'FI');
INSERT INTO COURSE (ID, YEAR, FACULTY)
VALUES (2, 2019, 'FEN');
INSERT INTO COURSE (ID, YEAR, FACULTY)
VALUES (3, 2019, 'FGN');
INSERT INTO COURSE (ID, YEAR, FACULTY)
VALUES (4, 2019, 'FPRN');
INSERT INTO COURSE (ID, YEAR, FACULTY)
VALUES (5, 2019, 'FSNST');

INSERT INTO USER(ID, NAME, PASSWORD, LOGIN,ROLE) VALUES (0,'string','$2a$04$eax4hv/iPeNneBtky.G8reAWCI2r6r07z6yEn6BTV2r.9OufLrxRS','string','ROLE_MANAGER');
INSERT INTO COURSE(ID,YEAR,FACULTY) VALUES (0,1,'test');

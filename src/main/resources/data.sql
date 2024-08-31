insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE) values(10001, 'jewan', 'H2 Insert Test', CURRENT_DATE, false);
insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE) values(10002, 'jewan', 'Taekbae LOVE', CURRENT_DATE, false);
insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE) values(10003, 'jewan', 'WE WILL MEET SOON', CURRENT_DATE, false);
insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE) values(10004, 'jewan', 'SHOPO, YOU TOO', CURRENT_DATE, false);
--
insert into user_details(ID, NAME, BIRTH_DATE) values (10001, 'Jewan', CURRENT_DATE());
insert into user_details(ID, NAME, BIRTH_DATE) values (10002, 'Taekbae', CURRENT_DATE());
insert into user_details(ID, NAME, BIRTH_DATE) values (10003, 'Shopo', CURRENT_DATE());

insert into post(ID, DESCRIPTION, USER_ID) values (20001, 'I WANT TO LEARN KOTLIN', 10001);
insert into post(ID, DESCRIPTION, USER_ID) values (20002, 'I NEED 츄르', 10001);

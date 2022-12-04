-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into users (id, name, surname, email, birthday, phone, city)
values ((SELECT nextval('users_seq')), 'alessandro', 'amedei', 'alessandroamedei18@gmail.com', date('1997-04-18'),
        '3477742956', 'Florence');
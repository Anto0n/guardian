insert into guardian.citizenship (citizenship) values ('Україна');
insert into guardian.citizenship (citizenship) values ('Росія');
insert into guardian.citizenship (citizenship) values ('Білорусія');

insert into guardian.city (city) values ('Київ');
insert into guardian.city (city) values ('Москва');
insert into guardian.city (city) values ('Мінськ');

insert into guardian.department (department) values ('Відділ 1');
insert into guardian.department (department) values ('Відділ 2');
insert into guardian.department (department) values ('Відділ 3');

insert into guardian.user (firstName, lastName, inn, citizenshipId, birthDate, cityId, tel, departmentId) values ('Сергій', 'Іванов',  '12345678', '1', '11011991', '1', '672510170', '1');
insert into guardian.user (firstName, lastName, inn, citizenshipId, birthDate, cityId, tel, departmentId) values ('Сергій', 'Іванов',  '12345678', '1', '11011991', '1', '672510170', '1');
insert into guardian.user (firstName, lastName, inn, citizenshipId, birthDate, cityId, tel, departmentId) values ('Андрій', 'Шевченко', '87654321', '2', '11111992', '2', '672554470', '2');
insert into guardian.user (firstName, lastName, inn, citizenshipId, birthDate, cityId, tel, departmentId) values ('Олександр', 'Шевченко', '67854123', '2', '11111993', '2', '672554475', '1');
insert into guardian.user (firstName, lastName, inn, citizenshipId, birthDate, cityId, tel, departmentId) values ('Олена', 'Ткаченко', '95132149', '3', '20121999', '3', '935114537', '3');
insert into guardian.user (firstName, lastName, inn, citizenshipId, birthDate, cityId, tel, departmentId) values ('Тарас', 'Панюта', '67854123', '1', '27032000', '1', '0442554470', '1');
insert into guardian.user (firstName, lastName, inn, citizenshipId, birthDate, cityId, tel, departmentId) values ('Софія', 'Бондаренко', '97812356', '2', '22101987', '2', '0442554470', '1');


insert into guardian.photo (userId, reference) values (1,'Фото1');
insert into guardian.photo (userId, reference) values (1,'Фото2');
insert into guardian.photo (userId, reference) values (2,'Фото3');
insert into guardian.photo (userId, reference) values (5,'Фото4');

USE guardian;
SELECT firstName, lastName, birthDate, city, citizenship FROM guardian.user JOIN city c ON user.cityId = c.id JOIN citizenship c2 ON user.citizenshipId = c2.id;
SELECT * FROM guardian.citizenship ;
# select * from user where user.firstName = 'Сергій' and user.lastName = 'Іванов' and user.birthDate = '11011991';
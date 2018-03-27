insert into guardian.citizenship (citizenship) values ('Українці');
insert into guardian.citizenship (citizenship) values ('Росіяни');
insert into guardian.citizenship (citizenship) values ('Білоруси');

insert into guardian.city (city) values ('Київ');
insert into guardian.city (city) values ('Москва');
insert into guardian.city (city) values ('Мінськ');

insert into guardian.department (department) values ('Відділ 1');
insert into guardian.department (department) values ('Відділ 2');
insert into guardian.department (department) values ('Відділ 3');

insert into guardian.user (firstName, lastName, inn, citizenshipId, birthDate, cityId, tel, departmentId) values ('Сергій', 'Іванов',  '12345678', '1', '11011991', '1', '0442510170', '1');
insert into guardian.user (firstName, lastName, inn, citizenshipId, birthDate, cityId, tel, departmentId) values ('Андрій', 'Шевченко', '87654321', '2', '11111992', '2', '0442554470', '2');


insert into guardian.photo (userId, reference) values (1,'Фото1');
insert into guardian.photo (userId, reference) values (1,'Фото2');
insert into guardian.photo (userId, reference) values (2,'Фото3');

SELECT firstName, lastName, birthDate, city, citizenship FROM guardian.user JOIN city c ON user.cityId = c.id JOIN citizenship c2 ON user.citizenshipId = c2.id;
SELECT * FROM guardian.citizenship ;
insert into guardian.citizenship (citizenship) values ('Українці');
insert into guardian.citizenship (citizenship) values ('Росіяни');
insert into guardian.citizenship (citizenship) values ('Білоруси');

insert into guardian.city (city) values ('Київ');
insert into guardian.city (city) values ('Москва');
insert into guardian.city (city) values ('Мінськ');

insert into guardian.department (department) values ('Відділ 1');
insert into guardian.department (department) values ('Відділ 2');
insert into guardian.department (department) values ('Відділ 3');

insert into guardian.user (firstName, lastName, inn, citizenshipId, birthDate, cityId, tel, departmentId) values ('Іванов', 'Сергій', '12345678', '1', '01011991', '1', '0442510170', '1');
insert into guardian.user (firstName, lastName, inn, citizenshipId, birthDate, cityId, tel, departmentId) values ('Шевченко', 'Андрій', '87654321', '2', '11111992', '2', '0442554470', '2');


insert into guardian.photo (userId, reference) values (1,'Фото1');
insert into guardian.photo (userId, reference) values (1,'Фото2');
insert into guardian.photo (userId, reference) values (2,'Фото3');

SELECT * FROM user;
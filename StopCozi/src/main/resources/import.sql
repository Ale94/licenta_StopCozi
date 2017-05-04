/*CREATE SCHEMA stopcozi ;*/

INSERT INTO stopcozi.role (role_id, name) VALUES ('0', 'ROLE_USER');
INSERT INTO stopcozi.role (role_id, name) VALUES ('1', 'ROLE_ADMIN');

INSERT INTO stopcozi.city (city_id, country, name, no_people) VALUES ('0', 'Romania', 'Timisoara', '1000');
INSERT INTO stopcozi.city (city_id, country, name, no_people) VALUES ('1', 'Romania', 'Arad', '800');
INSERT INTO stopcozi.city (city_id, country, name, no_people) VALUES ('2', 'Romania', 'Oradea', '900');
INSERT INTO stopcozi.city (city_id, country, name, no_people) VALUES ('3', 'Romania', 'Bucuresti', '10000');

INSERT INTO stopcozi.agency (agency_id, adresa, nume, city_id) VALUES ('0', 'Calea Șagului, Timișoara', 'RCS&RDS Timisoara', '0');
INSERT INTO stopcozi.agency (agency_id, adresa, nume, city_id) VALUES ('1', 'Strada Ștefan cel Mare 25, Timișoara 307200', 'Enel ', '0');
INSERT INTO stopcozi.agency (agency_id, adresa, nume, city_id) VALUES ('2', 'Bulevardul Mihai Eminescu 2B, Timișoara', 'Direcția Fiscală a Municipiului Timişoara', '0');
INSERT INTO stopcozi.agency (agency_id, adresa, nume, city_id) VALUES ('3', ' Bd. Revolutiei, 77-79, Arad, Arad, 310130, Arad', 'Administraţia Finanţelor Publice Arad', '1');
INSERT INTO stopcozi.agency (agency_id, adresa, nume, city_id) VALUES ('4', 'Piața Unirii 1, Oradea 410100', 'Oradea City Hall', '2');

INSERT INTO stopcozi.service (service_id, name, agency_id) VALUES ('0', 'Plata amenda,', '0');
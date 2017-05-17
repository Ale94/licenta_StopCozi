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



INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('1', 'Legislativ', 'Camera Deputaţilor');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('2', 'Legislativ', 'Senatul României');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('3', 'Legislativ ', 'Consiliu Judeţean');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('4', 'Legislativ', 'Consiliu Local');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('5', 'Executiv', 'Guvernul');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('6', 'Executiv', 'Ministerul Mediului');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('7', 'Executiv', 'Ministerul Afacerilor Interne');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('8', 'Executiv', 'Ministerul Afacerilor Externe');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('9', 'Executiv', 'Ministerul Educației Naționale ');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('10', 'Executiv', 'Ministerul Apărării Naționale ');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('11', 'Executiv', 'Ministerul Justiției');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('12', 'Executiv', 'Ministerul Sănătății');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('13', 'Executiv', 'Ministerul Energiei');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('14', 'Executiv', 'Ministerul Transportului');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('15', 'Executiv', 'Ministerul Comertului');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('16', 'Executiv', 'Prefectura');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('17', 'Executiv', 'Primarie');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('18', 'Judecatoresc', 'Tribunal');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('19', 'Judecatoresc', 'Parchet');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('20', 'Judecatoresc', 'Consiliul Superior al Magistraturii');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('21', 'Judecatoresc', 'Înalta Curte de Casatie si Justitie');
INSERT INTO `stopcozi`.`institutie` (`id_institutie`, `domeniu`, `nume_institutie`) VALUES ('22', 'Judecatoresc', 'Instanță judecătorească ');

UPDATE `stopcozi`.`institutie` SET `nume_institutie`='Camera Deputatilor' WHERE `id_institutie`='1';
UPDATE `stopcozi`.`institutie` SET `nume_institutie`='Consiliu Judetean' WHERE `id_institutie`='3';
UPDATE `stopcozi`.`institutie` SET `nume_institutie`='Ministerul Educatiei Nationale ' WHERE `id_institutie`='9';
UPDATE `stopcozi`.`institutie` SET `nume_institutie`='Ministerul Apararii Nationale ' WHERE `id_institutie`='10';
UPDATE `stopcozi`.`institutie` SET `nume_institutie`='Ministerul Justitiei' WHERE `id_institutie`='11';
UPDATE `stopcozi`.`institutie` SET `nume_institutie`='Ministerul Sanatatii' WHERE `id_institutie`='12';
UPDATE `stopcozi`.`institutie` SET `nume_institutie`='Instanta judecatoreasca' WHERE `id_institutie`='22';


INSERT INTO `stopcozi`.`agency` (`agency_id`, `adresa`, `nr_tel`, `nume`, `city_id`, `id_institutie`) VALUES ('1', 'Timisoara, Strada Corbului, nr. 4', '0256201772', 'Casa Judeteana de Asigurari de Sanatate Timis (CJASTM)', '3', '12');
INSERT INTO `stopcozi`.`agency` (`agency_id`, `adresa`, `nr_tel`, `nume`, `city_id`, `id_institutie`) VALUES ('2', ' Timisoara, Bulevardul Take Ionescu, nr. 46', '0256402703', 'Politia Rutiera', '3', '11');
INSERT INTO `stopcozi`.`agency` (`agency_id`, `adresa`, `nr_tel`, `nume`, `city_id`, `id_institutie`) VALUES ('3', 'Timisoara, Strada Aristide Demetriade nr. 1', '0256210010', 'Birou Inmatriculari si Birou Permise de Conducere', '3', '11');
INSERT INTO `stopcozi`.`agency` (`agency_id`, `adresa`, `nr_tel`, `nume`, `city_id`, `id_institutie`) VALUES ('4', 'Timisoara, Strada Paris, nr. 2A, et. 1 ', '0256220835', 'Oficiul Registrului Comertului de pe langa Tribunalul Timis', '3', '15');
INSERT INTO `stopcozi`.`agency` (`agency_id`, `adresa`, `nr_tel`, `nume`, `city_id`, `id_institutie`) VALUES ('5', 'Timisoara, Bulevardul Take Ionescu, nr. 46 ', '0256402110', 'Inspectoratul de Politie al Judetului Timis', '3', '11');
INSERT INTO `stopcozi`.`agency` (`agency_id`, `adresa`, `nr_tel`, `nume`, `city_id`, `id_institutie`) VALUES ('6', 'Timișoara, Strada Aristide Demetriade, nr. 1', '0256227003/292', 'Serviciul Pasapoarte', '3', '17');
INSERT INTO `stopcozi`.`agency` (`agency_id`, `adresa`, `nr_tel`, `nume`, `city_id`, `id_institutie`) VALUES ('7', 'Timisoara, Bulevardul Take Ionescu, nr. 56', '0356803700', 'Regia Autonoma de Transport Timisoara (RATT)', '3', '14');
INSERT INTO `stopcozi`.`agency` (`agency_id`, `adresa`, `nr_tel`, `nume`, `city_id`, `id_institutie`) VALUES ('8', 'Arad, Strada General Vasile Milea, nr. 2-4', '0257256484', 'Judecatoria Arad', '0', '22');
INSERT INTO `stopcozi`.`agency` (`agency_id`, `adresa`, `nr_tel`, `nume`, `city_id`, `id_institutie`) VALUES ('9', 'Arad, Bulevardul Revolutiei, nr. 45', '0257270202', 'Casa Judeteana de Asigurari de Sanatate Arad', '0', '12');
INSERT INTO `stopcozi`.`agency` (`agency_id`, `adresa`, `nr_tel`, `nume`, `city_id`, `id_institutie`) VALUES ('10', 'Arad, Bulevardul Revolutiei, nr. 75', '0257281850', 'Primaria Municipiului Arad', '0', '17');
INSERT INTO `stopcozi`.`agency` (`agency_id`, `adresa`, `nr_tel`, `nume`, `city_id`, `id_institutie`) VALUES ('11', 'Bulevardul Constantin Diaconovici Loga 1, Timisoara 300030', '0256 408 300', 'Primaria Timisoara', '3', '17');

UPDATE `stopcozi`.`city` SET `no_people`='159704' WHERE `city_id`='0';
UPDATE `stopcozi`.`city` SET `no_people`='196367' WHERE `city_id`='1';
UPDATE `stopcozi`.`city` SET `no_people`='2106144' WHERE `city_id`='2';
UPDATE `stopcozi`.`city` SET `no_people`='319279' WHERE `city_id`='3';

INSERT INTO `stopcozi`.`service` (`service_id`, `acte_necesare`, `name`, `agency_id`) VALUES ('1', 'Carte de identitate, proces verbal', 'Plata amenda', '5');
INSERT INTO `stopcozi`.`service` (`service_id`, `acte_necesare`, `name`, `agency_id`) VALUES ('2', 'Carte de identitate, talonul masinii', 'Declaratie accident', '5');
INSERT INTO `stopcozi`.`service` (`service_id`, `acte_necesare`, `name`, `agency_id`) VALUES ('3', 'Carte de identitate, copie certificat, declaratie venit', 'Impozit casa', '11');
INSERT INTO `stopcozi`.`service` (`service_id`, `acte_necesare`, `name`, `agency_id`) VALUES ('4', 'Carte de identitate, copie certificat, declaratie venit', 'Impozit masina', '11');
INSERT INTO `stopcozi`.`service` (`service_id`, `acte_necesare`, `name`, `agency_id`) VALUES ('5', 'Carte de identitate, copie certificat, declaratie venit', 'Impozit pamant', '11');
INSERT INTO `stopcozi`.`service` (`service_id`, `acte_necesare`, `name`, `agency_id`) VALUES ('6', 'Carte de identitate, copie certificat, declaratie venit', 'Impozit masina', '10');
INSERT INTO `stopcozi`.`service` (`service_id`, `acte_necesare`, `name`, `agency_id`) VALUES ('7', 'Carte de identitate, copie certificat, declaratie venit', 'Impozit pamant', '10');
INSERT INTO `stopcozi`.`service` (`service_id`, `acte_necesare`, `name`, `agency_id`) VALUES ('8', 'Carte de identitate, copie certificat, declaratie venit', 'Impozit masina', '10');

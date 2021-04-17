/* [ 1. table 만들기 ] */

CREATE TABLE Constructors (
    constructor varchar(20),
    country varchar(20),
    engine varchar(10),
    races_entered INT,
    height INT,
    width INT,

    primary key (constructor)
)
CREATE TABLE Drivers (
    driver varchar(20),
    birthday DATE,
    country varchar(20),
    constructor varchar(20),

    primary key (driver),
    foreign key (constructor) references Constructors
)
CREATE TABLE Races (
    Name varchar(30),
    beginDate DATE,
    area varchar(20),

    primary key (Name)
)
CREATE TABLE Results (
    Race varchar(20),
    driver varchar(20),
    race_rank varchar(20),

    primary key (Race, driver),
    foreign key (Race) references Races,
    foreign key (driver) references Drivers
)

/* 결과 보기
DESCRIBE Constructors
DESCRIBE Drivers
DESCRIBE Races
DESCRIBE Results
*/

/* [ 2. 데이터 삽입 ]
순서: Constructors - Drivers - Races - Results */

INSERT INTO Constructors 
values 
('McLaren','British','Mercedes', 884, 95, 180),
('BMW Sauber','German','BMW', 70, 95, 180),
('Renault','French','Renault', 660, 91, 175),
('Ferrari','Italian','Ferrari', 1010, 93, 180),
('Toyota','Japanese','Toyota', 1140, 91, 175),
('Red bull','Austrian','Honda', 304, 91, 175),
('Honda','Japanese','Honda', 88, 91, 175),
('Toro Rosso','Italian','Ferrari', 268, 93, 180),
('Jaguar','British','Cosworth', 85, 93, 178)

INSERT INTO Drivers 
values 
('hamilton','07/01/1985','British','McLaren'),
('heidfeld','10/05/1977','German','BMW Sauber'),
('alonso','29/07/1981','Spanish','Renault'),
('raikkonen','17/10/1979','Finnish','Ferrari'),
('kubica','07/12/1984','Polish','BMW Sauber'),
('massa','25/04/1981','Brazilian','Ferrari'),
('trulli','13/07/1974','Italian','Toyota'),
('webber','27/08/1976','Australian','Red Bull'),
('button','19/01/1980','British','Honda'),
('vettel','03/07/1987','German','Toro Rosso'),
('barrichello','23/05/1972','Brazilian','Honda'),
('Irvine','10/11/1965','British','Jaguar'),
('Schmacher','03/01/1969','German','Ferrari')

INSERT INTO Races
values 
('Australian Grand Prix','2009-03-29','Australia'),
('British Grand Prix','2009-06-21','Europe')
('German Grand Prix ','2009-06-21','Europe'),
('European Grand Prix','2009-08-23','Europe'),
('Abu Dhabi Grand Prix','2009-11-01','Middle East'),
('Malaysian Grand Prix','2008-03-23','Asia'),
('Spanish Grand Prix','2008-04-27','Europe'),
('Singapore Grand Prix','2008-09-28','Asia'),
('Brazilian Grand Prix','2008-11-02','Sorth America'),
('Monaco Grand Prix','2007-05-27','Africa'),
('Canadian Grand Prix','2007-06-10','North America'),
('United States Grand Prix','2007-06-17','North America'),
('French Grand Prix','2007-07-01','Europe'),
('Italian Grand Prix','2007-09-09','Europe'),
('San Marino Grand Prix','2004-04-25','Europe')


INSERT INTO Results
values 
('Australian Grand Prix','trulli','first place'),
('Australian Grand Prix','barrichello','second place'),
('Australian Grand Prix','button','third place'),

('British Grand Prix','button','first place'),
('British Grand Prix','barrichello','second place'),
('British Grand Prix','vettel','third place'),

('German Grand Prix ','button','first place'),
('German Grand Prix ','vettel','second place'),
('German Grand Prix ','webber','third place'),

('European Grand Prix','button','first place'),
('European Grand Prix','barrichello','second place'),
('European Grand Prix','webber','third place'),

('Abu Dhabi Grand Prix','button','first place'),
('Abu Dhabi Grand Prix','vettel','second place'),
('Abu Dhabi Grand Prix','barrichello','third place'),

('Malaysian Grand Prix','hamilton','first place'),
('Malaysian Grand Prix','heidfeld','second place'),
('Malaysian Grand Prix','raikkonen','third place'),

('Spanish Grand Prix','hamilton','second place'),

('Singapore Grand Prix','hamilton','first place'),
('Singapore Grand Prix','massa','second place'),
('Singapore Grand Prix','kubica','third place'),

('Brazilian Grand Prix','hamilton','first place'),
('Brazilian Grand Prix','massa','second place'),

('Monaco Grand Prix','alonso','first place'),
('Monaco Grand Prix','hamilton','second place'),
('Monaco Grand Prix','massa','third place'),

('Canadian Grand Prix','hamilton','first place'),
('Canadian Grand Prix','alonso','second place'),
('Canadian Grand Prix','massa','third place'),

('United States Grand Prix','hamilton','first place'),
('United States Grand Prix','alonso','second place'),
('United States Grand Prix','massa','third place'),

('French Grand Prix','hamilton','first place'),
('French Grand Prix','alonso','second place'),
('French Grand Prix','massa','third place'),

('Italian Grand Prix','hamilton','first place'),
('Italian Grand Prix','alonso','second place'),

('San Marino Grand Prix','Schmacher','first place'),
('San Marino Grand Prix','barrichello','second place')

/* 결과 보기
SELECT * FROM Constructors
SELECT * FROM Drivers
SELECT * FROM Races
SELECT * FROM Results
*/

/* [ 3. simple SQL query ]*/
a. SELECT name, country FROM Constructors where races_entered>=100
b. SELECT name, engine, races_entered from Constructors where (height!=95 and width<180) ORDER BY engine, races_entered
c. SELECT constructor from Constructors where engine='Ferrari'
d. SELECT driver as newBoys from Drivers where birthday>='1980-01-01'
e. SELECT driver,Race from Results where race_rank='first place'
f. SELECT * from Races where area='Europe' ORDER BY Name
g. SELECT driver from Drivers where driver='H%'
h. SELECT constructor from Constructors where constructor='_% _%'

/* [ 4.  sql query ] */
a. SELECT driver from Drivers as D, Constructors as C where (C.constructor=D.constructor and C.country='Italian')
b. SELECT driver from Constructors as C, Drivers as D where (C.country=D.country and C.constructor=D.constructor)
c. SELECT 

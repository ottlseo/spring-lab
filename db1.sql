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
    foreign key (country, constructor) references Constructors
)
CREATE TABLE Races (
    Name varchar(30),
    beginDate DATE,
    area varchar(20),

    primary key (Name),
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

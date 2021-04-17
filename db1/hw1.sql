CREATE TABLE Constructors (
    constructor varchar(20),
    country varchar(20),
    engine varchar(10),
    races_entered INT,
    height INT,
    width INT,

    primary key (constructor)
);
DESCRIBE Constructors;

CREATE TABLE Drivers (
    driver varchar(20),
    birthday DATE,
    country varchar(20),
    constructor varchar(20),

    primary key (driver),
    foreign key (constructor) references Constructors(constructor)
);
DESCRIBE Drivers;

CREATE TABLE Races (
    Name varchar(30),
    beginDate DATE,
    area varchar(20),

    primary key (Name)
);
DESCRIBE Races;

CREATE TABLE Results (
    Race varchar(30),
    driver varchar(20),
    race_rank varchar(20),

    primary key (Race, driver),
    foreign key (Race) references Races(Name),
    foreign key (driver) references Drivers(driver)
);
DESCRIBE Results;
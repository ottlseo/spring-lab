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
('Jaguar','British','Cosworth', 85, 93, 178);
SELECT * FROM Constructors;

INSERT INTO Drivers 
values 
('hamilton','1985-01-07','British','McLaren'),
('heidfeld','1977-05-10','German','BMW Sauber'),
('alonso','1981-07-29','Spanish','Renault'),
('raikkonen','1979-10-17','Finnish','Ferrari'),
('kubica','1984-12-07','Polish','BMW Sauber'),
('massa','1981-04-25','Brazilian','Ferrari'),
('trulli','1974-07-13','Italian','Toyota'),
('webber','1976-08-27','Australian','Red Bull'),
('button','1980-01-19','British','Honda'),
('vettel','1987-07-03','German','Toro Rosso'),
('barrichello','1972-05-23','Brazilian','Honda'),
('Irvine','1965-11-10','British','Jaguar'),
('Schmacher','1969-01-03','German','Ferrari');

SELECT * FROM Drivers;

INSERT INTO Races
values 
('Australian Grand Prix','2009-03-29','Australia'),
('British Grand Prix','2009-06-21','Europe'),
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
('San Marino Grand Prix','2004-04-25','Europe');
SELECT * FROM Races;

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
('San Marino Grand Prix','barrichello','second place');

SELECT * FROM Results;
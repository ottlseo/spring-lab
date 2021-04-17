SELECT constructor, country FROM Constructors where races_entered>=100;
SELECT constructor, engine, races_entered from Constructors where (height!=95 and width<180) ORDER BY engine, races_entered;
SELECT constructor from Constructors where engine='Ferrari';
SELECT driver as newBoys from Drivers where birthday>='1980-01-01';
SELECT driver,Race from Results where race_rank='first place';
SELECT * from Races where area='Europe' ORDER BY Name;
SELECT driver from Drivers where driver like 'H%';
SELECT constructor from Constructors where constructor like '_% _%';

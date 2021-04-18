SELECT D.driver from Drivers as D, Constructors as C where (C.country='Italian' and C.constructor=D.constructor);
SELECT D.driver from Constructors as C, Drivers as D where (C.country=D.country and C.constructor=D.constructor);
SELECT R.driver, C.engine, C.races_entered FROM Results as R, Drivers as D, Constructors as C where (R.Race='Monaco Grand Prix' and R.driver=D.driver and D.constructor=C.constructor);
SELECT constructor from Drivers group by constructor having count(driver)=1;
SELECT distinct(D.driver) from Drivers as D, Results as R where (R.driver=D.driver and R.Race='Spanish Grand Prix' or D.constructor='BMW Sauber');
SELECT D.driver, C.races_entered from Drivers as D, Constructors as C where (D.constructor=C.constructor) order by races_entered desc, driver desc;
SELECT c1.country from constructors c1 INNER JOIN constructors c2 ON c2.country=c1.country AND c2.engine='Mercedes' WHERE c1.engine='Cosworth';
SELECT distinct(r1.driver) from results r1 INNER JOIN results r2 ON r1.driver=r2.driver AND r1.race_rank='first place' WHERE r2.race_rank!='first place';
SELECT result.driver, date_format(race.beginDate,'%Y-%m') FROM Races as race, Results as result WHERE (beginDate between '2008-01-01' and '2009-12-31') AND result.race=race.Name;
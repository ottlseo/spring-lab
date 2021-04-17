SELECT D.driver from Drivers as D, Constructors as C where (C.country='Italian' and C.constructor=D.constructor);
SELECT D.driver from Constructors as C, Drivers as D where (C.country=D.country and C.constructor=D.constructor);
SELECT R.driver, C.engine, C.races_entered FROM Results as R, Drivers as D, Constructors as C where (R.Race='Monaco Grand Prix' and R.driver=D.driver and D.constructor=C.constructor);
SELECT constructor from Drivers group by constructor having count(driver)=1;
SELECT distinct(D.driver) from Drivers as D, Results as R where (R.driver=D.driver and R.Race='Spanish Grand Prix' or D.constructor='BMW Sauber');
SELECT D.driver, C.races_entered from Drivers as D, Constructors as C where (D.constructor=C.constructor) order by races_entered, driver desc;

g. (select country from Constructors where engine='Cosworth') intersect (select country from Constructors where engine='Mercedes');
h. (select driver from Results where race_rank="first place") intersect (select driver from Results where race_rank!="first place")
/* MySQL에는 intersect 명령어가 없으므로 inner join을 써준다 */
g. 
h.
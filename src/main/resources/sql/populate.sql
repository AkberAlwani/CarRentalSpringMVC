#INSERT INTO  `MEMBER` (firstname, lastname,age,title,membernumber, member_id) VALUES ('Curious','George',12,'Boy Monkey', 8754,'admin');
#INSERT INTO `MEMBER` (firstname, lastname,age,title,membernumber,member_id) VALUES ('Allen','Rench',123,'Torque Master', 8733,'guest');

INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO account(username,password,enabled,authority_id) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE,1);

INSERT INTO account(username,password,enabled,authority_id) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE,2);
 		

INSERT INTO vehicleType(name,description) values ('PASS','Passenger Car');
INSERT INTO vehicleType(name,description) values ('SUV','SUV 4x4');
INSERT INTO vehicleType(name,description) values ('MID','MidSize SUV');
INSERT INTO vehicleType(name,description) values ('TRUCK','Truck SUV');
INSERT INTO vehicleType(name,description) values ('CP','Coupe');
INSERT INTO vehicleType(name,description) values ('Cross','Crossover');
INSERT INTO vehicleType(name,description) values ('DISEL','Diesel');


insert into location (city,location,phone,zipcode) values('Fairfield','Burligton Ave','512125655',52556);
insert into location (city,location,phone,zipcode) values('Fairfield','Hoston Ave','512125655',52557);
insert into location (city,location,phone,zipcode) values('WillimsBurg','Java Ave','512125655',52556);
insert into location (city,location,phone,zipcode) values('Iowa','Spring Ave','512125655',78545);


insert into customer(city,country,customerNumber,firstname,lastName,account_id,email,phoneNumber)
values 
('Fairfield','USA','12345678','Akber','Ali',1,'aali@mum.edu','5122560929');
insert into customer(city,country,customerNumber,firstname,lastName,account_id,email,phoneNumber)
values 
('Fairfield','USA','12345677','Paul','Liu',2,'aali@mum.edu','5122567799');


INSERT INTO vehicle (vehicleId, dailyFine, dailyRate, make, makeyear, model, numberOfSeats, plateNumber, vehicleType_id,isavailable,location_Id)
 VALUES ('1', '10', '25', 'Toyota', '2010', 'Camery', '4', 'ABC123', '1',1,1);
INSERT INTO vehicle (vehicleId, dailyFine, dailyRate, make, makeyear, model, numberOfSeats, plateNumber, vehicleType_id,isavailable,location_id) 
VALUES ('2', '10', '50', 'Toytoa', '2016', 'Camery', '4', 'ABB222', '1',1,1);
INSERT INTO vehicle (vehicleId, dailyFine, dailyRate, make, makeyear, model, numberOfSeats, plateNumber, vehicleType_id,isavailable,location_id)
 VALUES ('3', '10', '35', 'Nissa', '2017', 'Altima', '4', 'AC2323', '1',1,1);
INSERT INTO vehicle (vehicleId, dailyFine, dailyRate, make, makeyear, model, numberOfSeats, plateNumber, vehicleType_id,isavailable,location_id)
 VALUES ('4', '10', '35', 'Nissa', '2016', 'Sunny', '4', 'AC2323', '1',1,1);
INSERT INTO vehicle (vehicleId, dailyFine, dailyRate, make, makeyear, model, numberOfSeats, plateNumber, vehicleType_id,isavailable,location_id)
 VALUES ('5', '10', '35', 'Ford', '2017', 'Exporlorer', '4', 'AC2323', '1',1,2);

INSERT INTO vehicle (vehicleId, dailyFine, dailyRate, isAvailable, make, makeyear, model, numberOfSeats, plateNumber, location_Id, vehicleType_id) 

VALUES ('6', '10', '30', 1, 'Ford', '2017', 'Escape', '7', 'AA11111', '1', '2');

INSERT INTO vehicle (vehicleId, dailyFine, dailyRate, isAvailable, make, makeyear, model, numberOfSeats, plateNumber, location_Id, vehicleType_id) 

VALUES ('7', '15', '40', 1, 'Toyota', '2017', 'Rav4', '7', 'BB1111', '1', '2');

INSERT INTO vehicle (vehicleId, dailyFine, dailyRate, isAvailable, make, makeyear, model, numberOfSeats, plateNumber, location_Id, vehicleType_id) 

VALUES ('8', '15', '40', 1, 'Toyota', '2016', 'Sport', '7', 'AA5555', '1', '2');


INSERT INTO vehicle (vehicleId, dailyFine, dailyRate, isAvailable, make, makeyear, model, numberOfSeats, plateNumber, location_Id, vehicleType_id) 

VALUES ('9', '15', '30', 1, 'Toyota', '2015', 'Sport', '7', 'ZZ5555', '1', '2');

INSERT INTO vehicle (vehicleId, dailyFine, dailyRate, isAvailable, make, makeyear, model, numberOfSeats, plateNumber, location_Id, vehicleType_id) 

VALUES ('10', '15', '30', 1, 'Toyota', '2014', 'Sport', '7', 'DD5555', '1', '2');



INSERT INTO reservation (reservationId, dailyRate, finePerDay, mileageIn, mileageOut, pickUpDateTime, pricePerDay, reservationDateTime, state, customer_id, vehicle_vehicleId) 
VALUES ('1', '25', '10', '12545', '12555', '2017-07-19 00:00:00', '25', '2017-07-19 23:15:04', '0', '1', '1');

INSERT INTO reservation (reservationId, dailyRate, finePerDay, mileageIn, mileageOut, pickUpDateTime, pricePerDay, reservationDateTime, state, customer_id, vehicle_vehicleId) 
VALUES ('2', '25', '10', '13000', '13000', '2017-07-19 00:00:00', '25', '2017-07-19 23:15:04', '0', '1', '2');

INSERT INTO reservation (reservationId, dailyRate, finePerDay, mileageIn, mileageOut, pickUpDateTime, pricePerDay, reservationDateTime, state, customer_id, vehicle_vehicleId) 
VALUES ('3', '33', '12', '5643', '5443', '2017-07-19 00:00:00', '25', '2017-07-19 23:15:04', '0', '2', '3');

INSERT INTO reservation (reservationId, dailyRate, finePerDay, mileageIn, mileageOut, pickUpDateTime, pricePerDay, reservationDateTime, state, customer_id, vehicle_vehicleId) 
VALUES ('4', '35', '15', '785', '785', '2017-07-19 00:00:00', '25', '2017-07-19 23:15:04', '0', '2', '3');



INSERT INTO payment VALUES (1,25,'1001-1002-1003-1004','123','06/2020','PAID','2017-07-19 18:15:25','Credit Card',3);

INSERT INTO payment VALUES (2,50,'2001-2002-2003-2004','123','06/2023','PAID','2017-07-19 18:16:19','Master Card',4);


INSERT INTO payment VALUES ('3', '35', '1646464654', '666', '06/2023', 'PAID', '2017-07-19 18:16:19', 'Cash', '1');

INSERT INTO payment VALUES ('4', '35', '165311-546465', '655', '06/2021', 'PAID', '2017-07-19 18:16:19', 'Cash', '2');


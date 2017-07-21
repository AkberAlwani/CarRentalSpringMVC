insert into customer(city,country,customerNumber,firstname,lastName,account_id,email,phoneNumber)
values 
('Fairfield','USA','12345678','Akber','Ali',1,'aali@mum.edu','5122560929');
insert into customer(city,country,customerNumber,firstname,lastName,account_id,email,phoneNumber)
values 
('Fairfield','USA','12345677','Paul','Liu',2,'aali@mum.edu','5122567799');

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


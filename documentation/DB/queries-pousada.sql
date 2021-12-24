-- Usuario
CREATE TABLE client(
	id serial,
	name varchar,
	last_name varchar,
	cpf varchar,
	rg varchar,
	passport varchar,
	rne varchar,
	birth_date date,
	registration_date date,
	PRIMARY KEY(id)
);

-- Room
CREATE TABLE room(
	room_number integer,
	sector integer,
	type varchar,
	maximum_capacity integer,
	PRIMARY KEY(room_number)
);

-- Booking
CREATE TABLE booking(
	id serial,
	booking_client integer,
	check_in_date date,
	check_out_date date,
	status varchar,
	PRIMARY KEY(id),
	FOREIGN KEY(booking_client) REFERENCES client(id)
);

-- Booking-Rooms
CREATE TABLE booking_rooms(
	booking_id integer,
	room_number integer,
	PRIMARY KEY(booking_id, room_number),
	FOREIGN KEY(booking_id) REFERENCES booking(id),
	FOREIGN KEY(room_number) REFERENCES room(room_number)
);

-- Booking-clients
CREATE TABLE booking_clients(
	booking_id integer,
	client_id integer,
	PRIMARY KEY(booking_id, client_id),
	FOREIGN KEY(booking_id) REFERENCES booking(id),
	FOREIGN KEY(client_id) REFERENCES client(id)
);

-- Prices
CREATE TABLE prices(
	ammount_clients integer,
	season varchar,
	price decimal,
	PRIMARY KEY(ammount_clients, season)
);

-- Invoice
CREATE TABLE invoice(
	id integer,
	booking_id integer,
	price decimal,
	PRIMARY KEY(id),
	FOREIGN KEY(booking_id) REFERENCES booking(id)
);

-- USE CASES
	-- cadastrar multiplos usuarios (pelo menos 5) *************************************************

INSERT INTO client
        (name, last_name, cpf, rg, passport, rne, birth_date, registration_date)
VALUES
        ('Onias', 'da Rocha Filho', '03037334118', '23848693', 'na', 'na', '1995-03-30', now());

INSERT INTO client
        (name, last_name, cpf, rg, passport, rne, birth_date, registration_date)
VALUES
        ('Gabriela', 'Simone Cláudia Rodrigues', '87653012507', '485283505', 'na', 'na', '1951-08-12', now());

INSERT INTO client
        (name, last_name, cpf, rg, passport, rne, birth_date, registration_date)
VALUES
        ('Márcia', 'Caroline Brenda de Paula', '78309011555', '126074434', 'na', 'na', '1969-01-05', now());

INSERT INTO client
        (name, last_name, cpf, rg, passport, rne, birth_date, registration_date)
VALUES
        ('Esther', 'Luna Corte Real', '25209700062', '281063758', 'na', 'na', '1987-01-09', now());

INSERT INTO client
        (name, last_name, cpf, rg, passport, rne, birth_date, registration_date)
VALUES
        ('Lívia', 'Helena Alessandra Porto', '78244566256', '470925164', 'na', 'na', '1948-05-02', now());

-- cadastrar multiplos quartos (pelo menos 10) *************************************************
INSERT INTO room
        (room_number, sector, type, maximum_capacity)
values
        (21, 1, 'familia', 4);

INSERT INTO room
        (room_number, sector, type, maximum_capacity)
values
        (20, 1, 'familia', 4);

INSERT INTO room
        (room_number, sector, type, maximum_capacity)
values
        (19, 1, 'casal', 2);

INSERT INTO room
        (room_number, sector, type, maximum_capacity)
values
        (11, 21, 'familia', 4);

INSERT INTO room
        (room_number, sector, type, maximum_capacity)
values
        (12, 21, 'familia', 4);

INSERT INTO room
        (room_number, sector, type, maximum_capacity)
values
        (13, 21, 'familia', 4);

INSERT INTO room
        (room_number, sector, type, maximum_capacity)
values
        (14, 21, 'familia', 4);

INSERT INTO room
        (room_number, sector, type, maximum_capacity)
values
        (15, 22, 'familia', 4);

INSERT INTO room
        (room_number, sector, type, maximum_capacity)
values
        (16, 22, 'familia', 4);

INSERT INTO room
        (room_number, sector, type, maximum_capacity)
values
        (17, 22, 'familia', 4);

INSERT INTO room
        (room_number, sector, type, maximum_capacity)
values
        (18, 22, 'familia', 4);

SELECT * FROM room;

	-- cadastrar prices: *************************************************
	-- 	1 client, regular
INSERT INTO prices (ammount_clients, season, price)
VALUES (1, 'regular', 120.0);
	-- 	2 clients, regular
INSERT INTO prices (ammount_clients, season, price)
VALUES (2, 'regular', 140.0);
	-- 	3 clients, regular
INSERT INTO prices (ammount_clients, season, price)
VALUES (3, 'regular', 160.0);
	-- 	4 clients, regular
INSERT INTO prices (ammount_clients, season, price)
VALUES (4, 'regular', 180.0);
	-- 	2 clients, high
INSERT INTO prices (ammount_clients, season, price)
VALUES (2, 'high', 200.0);


	-- cadastrar reservas: *************************************************
	-- 	1 quarto, 2 dias, 1 hospede, pendente
INSERT INTO booking (booking_client, check_in_date, check_out_date, status)
VALUES (1, '2022-01-02', '2022-01-05', 'pendente');

INSERT INTO booking_rooms (booking_id, room_number)
VALUES (1, 19);

INSERT INTO booking_clients (booking_id, client_id)
VALUES (1, 2);

	-- 	1 quarto, 5 dias, 3 hospedes, confirmado
INSERT INTO booking (booking_client, check_in_date, check_out_date, status)
VALUES (3, '2022-01-05', '2022-01-10', 'confirmado');

INSERT INTO booking_rooms (booking_id, room_number)
VALUES (2, 21);

INSERT INTO booking_clients (booking_id, client_id)
VALUES (2, 1);

INSERT INTO booking_clients (booking_id, client_id)
VALUES (2, 3);

INSERT INTO booking_clients (booking_id, client_id)
VALUES (2, 4);

	-- 	2 quartos, 1 dia, 4 hospedes, confirmado
INSERT INTO booking (booking_client, check_in_date, check_out_date, status)
VALUES (4, '2022-01-05', '2022-01-06', 'confirmado');

INSERT INTO booking_rooms (booking_id, room_number)
VALUES (3, 11);

INSERT INTO booking_rooms (booking_id, room_number)
VALUES (3, 12);

INSERT INTO booking_clients (booking_id, client_id)
VALUES (3, 1);

INSERT INTO booking_clients (booking_id, client_id)
VALUES (3, 2);

INSERT INTO booking_clients (booking_id, client_id)
VALUES (3, 3);

INSERT INTO booking_clients (booking_id, client_id)
VALUES (3, 4);


SELECT * FROM client;
SELECT * FROM booking;
SELECT * FROM booking_clients;
SELECT * FROM booking_rooms;
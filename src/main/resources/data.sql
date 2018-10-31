insert into tipo_vehiculo_entity (id_tipo_vehiculo, nombre) values {(1,'Moto'), (2,'Carro')};

insert into parqueadero_entity (cilindraje, placa, tipo_vehiculo) 
 values {(200, '701-god', 'Carro'), (200, '713-god', 'Carro'), (200, '714-god', 'Carro'),
 		 (200, '702-god', 'Carro'), (200, '712-god', 'Carro'), (200, '715-god', 'Carro'),
 		 (200, '703-god', 'Carro'), (200, '711-god', 'Carro'), (200, '716-god', 'Carro'),
 		 (200, '704-god', 'Carro'), (200, '710-god', 'Carro'), (200, '717-god', 'Carro'),
 		 (200, '705-god', 'Carro'), (200, '709-god', 'Carro'), 
 		 (200, 'gsd', 'Moto'), (200, '72', 'Moto'), (200, 'god', 'Moto')};

insert into parqueadero_entity (cilindraje, placa, tipo_vehiculo, fecha_ingreso) 
 values (200, '701-god', 'Carro', '2018-10-30T16:00:40');
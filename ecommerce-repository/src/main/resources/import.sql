insert into account (id, first_name, last_name, username, password, email, enabled, account_non_expired,credentials_non_expired, account_non_locked ) VALUES (1, 'Jan', 'Kowalski', 'kowal', '$2a$10$hm3DsoRF0lZOdHHGtAkc0uX3gnGAGTx.bgVqQjWKVAYn7GEVDUDPi', 'jan.kowalski@o2.pl', TRUE,TRUE,TRUE,TRUE);
insert into account (id, first_name, last_name, username, password, email, enabled, account_non_expired,credentials_non_expired, account_non_locked ) VALUES (2, 'Kamil', 'Nowak', 'nowak', '$2a$10$hm3DsoRF0lZOdHHGtAkc0uX3gnGAGTx.bgVqQjWKVAYn7GEVDUDPi', 'kamil.nowak@o2.pl', TRUE,TRUE,TRUE,TRUE);
insert into account (id, first_name, last_name, username, password, email, enabled, account_non_expired,credentials_non_expired, account_non_locked ) VALUES (3, 'Artur', 'Nowy', 'artur', '$2a$10$hm3DsoRF0lZOdHHGtAkc0uX3gnGAGTx.bgVqQjWKVAYn7GEVDUDPi', 'artur.nowy@o2.pl', TRUE,TRUE,TRUE,TRUE);
insert into account (id, first_name, last_name, username, password, email, enabled, account_non_expired,credentials_non_expired, account_non_locked ) VALUES (4, 'Agnieszka', 'Głowacka', 'Aga', '$2a$10$hm3DsoRF0lZOdHHGtAkc0uX3gnGAGTx.bgVqQjWKVAYn7GEVDUDPi', 'agnieszka.glowacka@o2.pl', TRUE,TRUE,TRUE,TRUE);

insert into account_entity_roles (account_entity_id, roles) VALUES (1,'ADMIN'), (2,'CLIENT'), (3,'CLIENT'), (4,'CLIENT');


-- Producer ------------------------------------------------------------------------------------------------------------
INSERT INTO producer(id, producer) VALUES (1, 'Acer');
INSERT INTO producer(id, producer) VALUES (2, 'Apple');
INSERT INTO producer(id, producer) VALUES (3, 'ASUS');
INSERT INTO producer(id, producer) VALUES (4, 'Dell');
INSERT INTO producer(id, producer) VALUES (5, 'HP');
INSERT INTO producer(id, producer) VALUES (6, 'Kiano');
INSERT INTO producer(id, producer) VALUES (7, 'Kruger&Matz');
INSERT INTO producer(id, producer) VALUES (8, 'Lenovo');
INSERT INTO producer(id, producer) VALUES (9, 'MSI');
INSERT INTO producer(id, producer) VALUES (10, 'Toshiba');


-- CPU --------------------------------------------------------------------------------------------------------------
INSERT INTO processor(id, tdp, cache, cores, lithography, max_turbo_frequency, model, processor_base_frequency, processor_family, processor_graphics, producer, socket, threads) VALUES (1, 45, 6, 4, 14, 3.50, 'Core i7-6700HQ', 2.60, 'i7', 'Intel HD Graphics 530', 'Intel', 'Socket 1151', 8 );


-- Memory --------------------------------------------------------------------------------------------------------------
INSERT INTO memory(id, amount, frequency, type) VALUES (1, 8, 2133, 'SO-DIMM DDR4');
INSERT INTO memory(id, amount, frequency, type) VALUES (2, 16, 2133, 'SO-DIMM DDR4');


-- Hard Disc -----------------------------------------------------------------------------------------------------------
INSERT INTO hard_disc(id, size, type, input) VALUES (1, 120, 'SSD', 'SATA III');
INSERT INTO hard_disc(id, size, type, input) VALUES (2, 256, 'SSD', 'SATA III');

-- Operating System ----------------------------------------------------------------------------------------------------
INSERT INTO operating_system(id, name) VALUES (1, 'Windows 7');
INSERT INTO operating_system(id, name) VALUES (2, 'Windows 8');
INSERT INTO operating_system(id, name) VALUES (3, 'Windows 8.1');
INSERT INTO operating_system(id, name) VALUES (4, 'Microsoft Windows 10 Home PL (wersja 64-bitowa)');


-- Memory --------------------------------------------------------------------------------------------------------------
INSERT INTO memory(id, amount, frequency, type) VALUES (1, 8, 2133, 'SO-DIMM DDR4');
INSERT INTO memory(id, amount, frequency, type) VALUES (2, 16, 2133, 'SO-DIMM DDR4');


-- CPU --------------------------------------------------------------------------------------------------------------
INSERT INTO processor(id, tdp, cache, cores, lithography, max_turbo_frequency, model, processor_base_frequency, processor_family, processor_graphics, producer, threads) VALUES (1, 45, 6, 4, 14, 3.50, 'Core i7-6700HQ', 2.60, 'i7', 'Intel HD Graphics 530', 'Intel', 8 );
INSERT INTO processor(id, tdp, cache, cores, lithography, max_turbo_frequency, model, processor_base_frequency, processor_family, processor_graphics, producer, threads) VALUES (2, 15, 4, 2, 14, 3.50, 'Core i7-7500U', 2.70, 'i7', 'Intel HD Graphics 620', 'Intel', 8 );


-- Hard Disc -----------------------------------------------------------------------------------------------------------
INSERT INTO hard_disc(id, size, type, input) VALUES (1, 120, 'SSD', 'SATA III');


-- Display Resolution --------------------------------------------------------------------------------------------------
INSERT INTO display_resolution(id, width, width) VALUES (1, 1080, 1920);
INSERT INTO display_resolution(id, height, width) VALUES (2,  768, 1366);
INSERT INTO display_resolution(id, height, width) VALUES (3,  900, 1600);
INSERT INTO display_resolution(id, height, width) VALUES (4,  2160, 3840);
INSERT INTO display_resolution(id, height, width) VALUES (5,  1800, 3200);
INSERT INTO display_resolution(id, height, width) VALUES (6,  1440, 2304);
INSERT INTO display_resolution(id, height, width) VALUES (7,  1080, 2560);
INSERT INTO display_resolution(id, height, width) VALUES (8,  1600, 2800);
INSERT INTO display_resolution(id, height, width) VALUES (9,  1800, 2560);
INSERT INTO display_resolution(id, height, width) VALUES (10, 900, 1440);
INSERT INTO display_resolution(id, height, width) VALUES (11, 1620, 2880);
INSERT INTO display_resolution(id, height, width) VALUES (12, 1080, 1920);


-- Display Size --------------------------------------------------------------------------------------------------------
INSERT INTO display_size(id, size) VALUES (1, 15.6);
INSERT INTO display_size(id, size) VALUES (2, 17.3);
INSERT INTO display_size(id, size) VALUES (3, 13.3);
INSERT INTO display_size(id, size) VALUES (4, 14.0);
INSERT INTO display_size(id, size) VALUES (5, 14.1);
INSERT INTO display_size(id, size) VALUES (6, 11.6);
INSERT INTO display_size(id, size) VALUES (7, 12.5);
INSERT INTO display_size(id, size) VALUES (8, 12.1);
INSERT INTO display_size(id, size) VALUES (9, 18.4);
INSERT INTO display_size(id, size) VALUES (10, 15.4);


-- Display Type --------------------------------------------------------------------------------------------------------
INSERT INTO display_type(id, type) VALUES (1, 'Matowy, LED');
INSERT INTO display_type(id, type) VALUES (2, 'Matowy, LED, IPS');
INSERT INTO display_type(id, type) VALUES (3, 'Matowy, LED, EWV');
INSERT INTO display_type(id, type) VALUES (4, 'Błyszczący, LED');
INSERT INTO display_type(id, type) VALUES (5, 'Błyszczący, LED, IPS, Retina');
INSERT INTO display_type(id, type) VALUES (6, 'Błyszczący, LED, IPS');
INSERT INTO display_type(id, type) VALUES (7, 'Błyszczący, LED, IPS, dotykowy');
INSERT INTO display_type(id, type) VALUES (8, 'Błyszczący, LED, dotykowy');
INSERT INTO display_type(id, type) VALUES (9, 'Matowy, LED, IPS, dotykowy');
INSERT INTO display_type(id, type) VALUES (10, 'Błyszczący, LED, EWV, dotykowy');


-- Graphics Card -------------------------------------------------------------------------------------------------------
INSERT INTO graphics_cart(id, name) VALUES (1, 'NVIDIA GeForce GTX 960M');
INSERT INTO graphics_cart(id, name) VALUES (2, 'NVIDIA GeForce GTX 950M');
INSERT INTO graphics_cart(id, name) VALUES (4, 'NVIDIA GeForce 940MX');
INSERT INTO graphics_cart(id, name) VALUES (5, 'NVIDIA GeForce 920MX');
INSERT INTO graphics_cart(id, name) VALUES (6, 'NVIDIA GeForce GTX 1060');
INSERT INTO graphics_cart(id, name) VALUES (7, 'NVIDIA GeForce 920M');
INSERT INTO graphics_cart(id, name) VALUES (8, 'NVIDIA GeForce GTX 970M');
INSERT INTO graphics_cart(id, name) VALUES (9, 'NVIDIA GeForce 940M');
INSERT INTO graphics_cart(id, name) VALUES (10, 'NVIDIA GeForce GTX 1070');
INSERT INTO graphics_cart(id, name) VALUES (11, 'NVIDIA GeForce GTX 980M');
INSERT INTO graphics_cart(id, name) VALUES (12, 'NVIDIA GeForce GTX 1050');
INSERT INTO graphics_cart(id, name) VALUES (13, 'NVIDIA GeForce GTX 965M');
INSERT INTO graphics_cart(id, name) VALUES (14, 'NVIDIA GeForce GTX 1050Ti');
INSERT INTO graphics_cart(id, name) VALUES (15, 'NVIDIA GeForce 930M');
INSERT INTO graphics_cart(id, name) VALUES (16, '2 x NVIDIA GeForce GTX 1080 SLI');
INSERT INTO graphics_cart(id, name) VALUES (17, 'NVIDIA GeForce GT 730M');
INSERT INTO graphics_cart(id, name) VALUES (18, '2 x NVIDIA GeForce GTX 1070 SLI');
INSERT INTO graphics_cart(id, name) VALUES (19, '2 x NVIDIA GeForce GTX 980M SLI');
INSERT INTO graphics_cart(id, name) VALUES (20, 'NVIDIA GeForce GT 630M');
INSERT INTO graphics_cart(id, name) VALUES (21, '2x NVIDIA GeForce GTX 970M SLI');
INSERT INTO graphics_cart(id, name) VALUES (22, 'NVIDIA GeForce 820M');
INSERT INTO graphics_cart(id, name) VALUES (23, 'NVIDIA GeForce GTX 1080');
INSERT INTO graphics_cart(id, name) VALUES (24, 'AMD Radeon R7 M445');
INSERT INTO graphics_cart(id, name) VALUES (25, 'AMD Radeon R9 M375');
INSERT INTO graphics_cart(id, name) VALUES (26, 'AMD Radeon R5 M330');
INSERT INTO graphics_cart(id, name) VALUES (27, 'AMD Radeon R7 M370');
INSERT INTO graphics_cart(id, name) VALUES (28, 'AMD Radeon R5 M420');
INSERT INTO graphics_cart(id, name) VALUES (29, 'AMD Radeon R5 M335');
INSERT INTO graphics_cart(id, name) VALUES (30, 'AMD Radeon R5 M315');
INSERT INTO graphics_cart(id, name) VALUES (31, 'AMD Radeon R7 M340');
INSERT INTO graphics_cart(id, name) VALUES (32, 'AMD Radeon R5 M430');
INSERT INTO graphics_cart(id, name) VALUES (33, 'AMD Radeon R7 M460');
INSERT INTO graphics_cart(id, name) VALUES (34, 'AMD Radeon Pro 455');
INSERT INTO graphics_cart(id, name) VALUES (35, 'AMD Radeon Pro 450');
INSERT INTO graphics_cart(id, name) VALUES (36, 'AMD Radeon R7 M265');
INSERT INTO graphics_cart(id, name) VALUES (37, 'AMD Radeon R7 M265');
INSERT INTO graphics_cart(id, name) VALUES (38, 'NVIDIA Quadro M1000M');
INSERT INTO graphics_cart(id, name) VALUES (39, 'NVIDIA Quadro M5000M');
INSERT INTO graphics_cart(id, name) VALUES (40, 'NVIDIA Quadro M600M');
INSERT INTO graphics_cart(id, name) VALUES (41, 'NVIDIA Quadro M2000M');


-- Input-Output types --------------------------------------------------------------------------------------------------
INSERT INTO input_output_types(id, input_output) VALUES (1, 'Wyjście słuchawkowe/wejście mikrofonowe');
INSERT INTO input_output_types(id, input_output) VALUES (2, 'Wyjście słuchawkowe/głośnikowe');
INSERT INTO input_output_types(id, input_output) VALUES (3, 'Wejście mikrofonowe');
INSERT INTO input_output_types(id, input_output) VALUES (4, 'Wejście liniowe Audio (minijack 3,5 mm)');
INSERT INTO input_output_types(id, input_output) VALUES (5, 'Wejście/wyjście liniowe Audio (minijack 3,5 mm)');
INSERT INTO input_output_types(id, input_output) VALUES (6, 'Wyjście liniowe Audio (minijack 3,5 mm)');
INSERT INTO input_output_types(id, input_output) VALUES (7, 'Audio HiFi.');
INSERT INTO input_output_types(id, input_output) VALUES (8, 'USB 3.1 Gen. 1 (USB 3.0)');
INSERT INTO input_output_types(id, input_output) VALUES (9, 'USB 2.0');
INSERT INTO input_output_types(id, input_output) VALUES (10, 'USB Typu-C');
INSERT INTO input_output_types(id, input_output) VALUES (11, 'USB Typu-C (z Thunderbolt)');
INSERT INTO input_output_types(id, input_output) VALUES (12, 'VGA (D-sub)');
INSERT INTO input_output_types(id, input_output) VALUES (13, 'Czytnik kart pamięci');
INSERT INTO input_output_types(id, input_output) VALUES (14, 'Czytnik kart pamięci microSD');
INSERT INTO input_output_types(id, input_output) VALUES (15, 'HDMI');
INSERT INTO input_output_types(id, input_output) VALUES (16, 'Micro HDMI');
INSERT INTO input_output_types(id, input_output) VALUES (17, 'Mini HDMI');
INSERT INTO input_output_types(id, input_output) VALUES (18, 'DC-in (wejście zasilania)');
INSERT INTO input_output_types(id, input_output) VALUES (19, 'RJ-45 (LAN)');
INSERT INTO input_output_types(id, input_output) VALUES (20, 'Mini Display Port');
INSERT INTO input_output_types(id, input_output) VALUES (21, 'Display Port');
INSERT INTO input_output_types(id, input_output) VALUES (22, 'Thunderbolt');
INSERT INTO input_output_types(id, input_output) VALUES (23, 'Thunderbolt 2');
INSERT INTO input_output_types(id, input_output) VALUES (24, 'Thunderbolt 3');
INSERT INTO input_output_types(id, input_output) VALUES (25, 'Czytnik Smart Card');
INSERT INTO input_output_types(id, input_output) VALUES (26, 'Noble Lock');
INSERT INTO input_output_types(id, input_output) VALUES (27, 'Złącze Amplifiera');
INSERT INTO input_output_types(id, input_output) VALUES (28, 'Gniazdo kart SIM');
INSERT INTO input_output_types(id, input_output) VALUES (29, 'ExpressCard 54');

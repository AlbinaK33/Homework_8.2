
CREATE TABLE `osbb_example`.`building` (
`id` INT NOT NULL AUTO_INCREMENT,
`adress_building` VARCHAR(45) NOT NULL,
`total_number_flat` TINYINT(2) NOT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE `osbb_example`.`flat` (
`id` INT NOT NULL AUTO_INCREMENT,
`number_flat` TINYINT(2) NOT NULL,
`square` FLOAT NOT NULL,
`building_id` INT NOT NULL,
PRIMARY KEY(`id`),
INDEX `fk_building_id` (`building_id` ASC) VISIBLE,
CONSTRAINT `fk_building_id`
FOREIGN KEY (`building_id`)
REFERENCES `osbb_example`.`building` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE
);

CREATE TABLE `osbb_example`.`resident` (
`id` INT NOT NULL AUTO_INCREMENT,
`resident_data` VARCHAR(45) NOT NULL,
`flat_id` INT NOT NULL,
PRIMARY KEY (`id`),
INDEX `fk_flat_id` (`flat_id` ASC) VISIBLE,
CONSTRAINT `fk_flat_id`
FOREIGN KEY (`flat_id`)
REFERENCES `osbb_example`.`flat` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE
);

CREATE TABLE `osbb_example`.`role` (
`resident_id` INT NOT NULL,
`role` VARCHAR(45) NOT NULL DEFAULT 'MEMBER',
INDEX `fk_resident_id` (`resident_id` ASC) VISIBLE,
CONSTRAINT `fk_resident_id`
FOREIGN KEY (`resident_id`)
REFERENCES `osbb_example`.`resident` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE
);

CREATE TABLE `osbb_example`.`charter` (
`resident_id` INT NOT NULL,
`autopark` ENUM('1', '0') NOT NULL,
`ownership` INT NOT NULL DEFAULT '1',
INDEX `fk_resident_id2` (`resident_id` ASC) VISIBLE,
CONSTRAINT `fk_resident_id2`
FOREIGN KEY (`resident_id`)
REFERENCES `osbb_example`.`resident` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE
);
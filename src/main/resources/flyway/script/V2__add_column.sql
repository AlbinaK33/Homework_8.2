ALTER TABLE `osbb_example`.`resident`
ADD `contact_data` VARCHAR(45) NOT NULL;
ALTER TABLE `osbb_example`.`resident`
ADD `residence` ENUM('1', '0') NOT NULL;
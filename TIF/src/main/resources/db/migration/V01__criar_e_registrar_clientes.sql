CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone_number` varchar(25) NOT NULL,
  `CPF` varchar(14) NOT NULL,
  `logradouro` varchar(20),
  `numero` varchar(20),
  `complemento` varchar(20),
  `bairro` varchar(20),
  `cidade` varchar(20),
  `estado` varchar(20),
  `cep` varchar(20),
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO client (id, name, email, telephone_number, CPF, active) 
	values (1, 'Fernando Duarte', 'fernandoduarte@ifsp.edu.br', '+55 (12)9999-9999', '000.000.000-00', 1);
INSERT INTO client (id, name, email, telephone_number, CPF, active) 
	values (2, 'Gislaine Rosales', 'gislainerosales@ifsp.edu.br', '+55 (12)9999-9999', '000.000.000-00', 1);
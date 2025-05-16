CREATE TABLE ordem_servico (
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	`description` VARCHAR(50) NOT NULL,
	`emission_date` DATE NOT NULL,
	`completion_date` DATE,
	`value` DECIMAL NOT NULL,
	`observation` VARCHAR(100),
	`status` ENUM('EM_APROVAÇÃO', 'APROVADA', 'EM_ANDAMENTO', 'FINALIZADA') NOT NULL,
	`client_id` BIGINT(20) NOT NULL,
	FOREIGN KEY (client_id) REFERENCES client(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE forma_pagamento (
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30),
	`ordem_servico_id` BIGINT(20) NOT NULL,
	FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO ordem_servico (description, emission_date, completion_date, value, observation, status, client_id)
values ('Troca de tela de PC', '2025-04-24', NULL, 300.0, NULL, 'EM_ANDAMENTO', 2);
INSERT INTO ordem_servico (description, emission_date, completion_date, value, observation, status, client_id)
values ('Concerto de notebook', '2025-04-22', NULL, 600.0, NULL, 'EM_APROVAÇÃO', 1);
INSERT INTO ordem_servico (description, emission_date, completion_date, value, observation, status, client_id)
values ('Concerto de iphone', '2025-03-30', '2025-04-24', 6000.0, NULL, 'FINALIZADA', 2);

INSERT INTO forma_pagamento (name, ordem_servico_id)
values ('Dinheiro', 1);
INSERT INTO forma_pagamento (name, ordem_servico_id)
values ('Credito', 2);
INSERT INTO forma_pagamento (name, ordem_servico_id)
values ('Debito', 3);


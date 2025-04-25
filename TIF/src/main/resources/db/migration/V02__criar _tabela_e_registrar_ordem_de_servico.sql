CREATE TABLE forma_pagamento (
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	`NAME` VARCHAR(20) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE ordem_servico (
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	`description` VARCHAR(50) NOT NULL,
	`emissionDate` DATE NOT NULL,
	`completionDate` DATE,
	`value` DECIMAL NOT NULL,
	`observation` VARCHAR(100),
	`status` VARCHAR(20) NOT NULL,
	`client_id` BIGINT(20) NOT NULL,
	FOREIGN KEY (client_id) REFERENCES client(id)
	`forma_pagamento_id` BIGINT(20) NOT NULL,
	FOREIGN KEY (forma_pagamento_id) REFERENCES forma_pagamento(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO forma_pagamento (name)
values ('Dinheiro');
INSERT INTO forma_pagamento (name)
values ('Credito');
INSERT INTO forma_pagamento (name)
values ('Debito');

INSERT INTO ordem_servico (description, emissionDate, completionDate, value, observation, status, client_id, forma_pagamento_id)
values ('Troca de tela de PC', '2025-04-24', NULL, 300.0, NULL, 'EM_ANDAMENTO', 2, 1);
INSERT INTO ordem_servico (description, emissionDate, completionDate, value, observation, status, client_id, forma_pagamento_id)
values ('Concerto de notebook', '2025-04-22', NULL, 600.0, NULL, 'EM_APROVAÇÃO', 1, 2);
INSERT INTO ordem_servico (description, emissionDate, completionDate, value, observation, status, client_id, forma_pagamento_id)
values ('Concerto de iphone', '2025-03-30', '2025-04-24', 6000.0, NULL, 'FINALIZADA', 2, 3);
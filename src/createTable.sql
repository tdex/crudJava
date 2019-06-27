CREATE TABLE `clientes` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `idade` int(11) DEFAULT NULL,
  PRIMARY KEY (`client_id`,`cpf`)
) DEFAULT CHARSET=utf8 COMMENT='tabela de clientes'
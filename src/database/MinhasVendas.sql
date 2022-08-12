USE supermercado;

CREATE TABLE if not exists `tbusuario` (
  `id` int NOT NULL auto_increment primary key ,
  nome varchar(255) NOT NULL default "Administrador",
  `user` varchar(255) not null default "Admin",
   `password` varchar(20) not null default "admin",
  `status` boolean not null default true
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
insert into tbusuario values(1,default,default,default,default);

CREATE TABLE if not exists `tbcategoria` (
  `id` int NOT NULL auto_increment primary key ,
  `nome` varchar(255) NOT NULL,
  `status` boolean not null 
);

CREATE TABLE if not exists `tbunidade` (
  `id` int NOT NULL auto_increment primary key ,
  `nome` varchar(255) NOT NULL,
  `status` boolean not null 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE if not exists `tbmarca` (
  `id` int auto_increment primary key not null,
  `nome` varchar(255) NOT NULL,
  `status` boolean not null 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE if not exists `tbproduto` 
(
  `id` int auto_increment primary key not null,
  codigoBarra varchar(25) not null,
  nome varchar(255) NOT NULL,
  categoria int not null references tbcategoria(id),
  marca int not null references tbmarca(id),
  unidade int not null references tbunidade(id),
  pesoLiquido double null,
  pesoBruto double null,
  custo decimal(10,2) not null,
  custoTotal decimal(10,2) not null,
  preco decimal(10,2) not null,
  estoque int not null,
  estoqueDisponivel int not null,
  discricao varchar(300) not null,
  Inserido date not null,
  `status` boolean not null 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE if not exists `tbpromocaoprod` 
(
  `id` int auto_increment primary key not null,
  dataInicio date NOT NULL,
  datafinal date NOT NULL,
  produto int not null references tbproduto(id),
  `status` boolean not null 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE if not exists `tbvalidadeprod` 
(
  `id` int auto_increment primary key not null,
  dataInicio date NOT NULL,
  datafinal date NOT NULL,
  produto int not null references tbproduto(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table if not exists tbtaxa(
id int not null auto_increment primary key,
nome varchar(50) not null,
taxa decimal(10,2) not null,
`status` boolean not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE if not exists `tbcliente` 
(
  `id` int auto_increment primary key not null,
  nome varchar(255) NOT NULL default "Consumidor",
  sexo varchar(20)  NOT NULL default "",
  nuit varchar(100) NOT NULL default "",
  numBI varchar(100) NOT NULL default "",
  email varchar(100)  NOT NULL default "",
  pais varchar(100)  NOT NULL default "",
  endereco varchar(255)  NOT NULL default "",
  bairro varchar(100)  NOT NULL default "",
  cidade varchar(100)  NOT NULL default "",
  telefone varchar(100) NOT NULL default "",
  `status` boolean not NULL default true
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
insert into tbcliente values(1,default,default,default,default,default,default,default,default,default,default,default);

CREATE TABLE if not exists `tbcaixa` 
(
  `id` int auto_increment primary key not null,
  nome varchar(255) NOT NULL default "CAIXA 01",
  `status` boolean not null default true
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into tbcaixa values(1,default,default);

CREATE TABLE if not exists `tbvenda` 
(
  `id` int auto_increment primary key not null,
  `status` varchar(50) NOT NULL,
  pagamento varchar(50) not null,
  cliente int not null references tbcliente(id),
  subtotal decimal(10,2) not null,
  desconto decimal(10,2) not null,
  taxa decimal(10,2) not null,
  total decimal(10,2) not null,
  troco decimal(10,2) not null,
  vendedor int not null references tbusuario(id),
  caixa int not null references tbcaixa(id),
  `data` varchar(20) not null,
  `hora` varchar(20) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE if not exists `tbitemvenda` 
(
  `id` int auto_increment primary key not null,
  produto int not null references tbproduto(id),
  quantidade int not null,
  preco decimal(10,2) not null,
  total decimal(10,2) not null,
  venda int not null references tbvenda(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE if not exists `tbpedido` 
(
  `id` int auto_increment primary key not null,
  `status` varchar(50) NOT NULL,
  pagamento varchar(50) not null,
  cliente int not null references tbcliente(id),
  subtotal decimal(10,2) not null,
  desconto decimal(10,2) not null,
  taxa decimal(10,2) not null,
  total decimal(10,2) not null,
  troco decimal(10,2) not null,
  vendedor int not null references tbusuario(id),
  caixa int not null references tbcaixa(id),
  `data` varchar(20) not null,
  `hora` varchar(20) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE if not exists `tbitempedido` 
(
  `id` int auto_increment primary key not null,
  produto int not null references tbproduto(id),
  quantidade int not null,
  preco decimal(10,2) not null,
  total decimal(10,2) not null,
  pedido int not null references tbpedido(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


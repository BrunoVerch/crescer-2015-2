-- Cidade
INSERT INTO Cidade (IDCidade, Nome, UF) VALUES (1, 'São Leopoldo', 'RS');
INSERT INTO Cidade (IDCidade, Nome, UF) VALUES (2, 'Novo Hamburgo', 'RS');

-- Servico
INSERT INTO Servico (IDServico, Descricao) VALUES (SEQ_Servico.nextval, 'Lavar');
INSERT INTO Servico (IDServico, Descricao) VALUES (SEQ_Servico.nextval, 'Secar');

-- Material
INSERT INTO Material (IDMaterial, Descricao) VALUES (SEQ_Material.nextval, 'Delicado');
INSERT INTO Material (IDMaterial, Descricao) VALUES (SEQ_Material.nextval, 'Normal');
INSERT INTO Material (IDMaterial, Descricao) VALUES (SEQ_Material.nextval, 'Pesado');

-- Cliente
INSERT INTO Cliente (IDCliente, Nome, CPF, Email, Endereco, Bairro, IDCidade, CEP, Situacao)
 VALUES (SEQ_Cliente.nextval, 'João da Silva', '52426419407', 'joao@gmail.com', 'R. São Joaquim, 948', 'Centro', 1, 93010190, '0');

-- Produto
INSERT INTO Produto (IDProduto, IDServico, IDMaterial, Valor)
 VALUES (SEQ_Produto.nextval, 1, 1, 5);

INSERT INTO Produto (IDProduto, IDServico, IDMaterial, Valor)
 VALUES (SEQ_Produto.nextval, 1, 2, 2.5);

INSERT INTO Produto (IDProduto, IDServico, IDMaterial, Valor)
 VALUES (SEQ_Produto.nextval, 1, 3, 4);

INSERT INTO Produto (IDProduto, IDServico, IDMaterial, Valor)
 VALUES (SEQ_Produto.nextval, 2, 1, 3.5);

INSERT INTO Produto (IDProduto, IDServico, IDMaterial, Valor)
 VALUES (SEQ_Produto.nextval, 2, 2, 2);

INSERT INTO Produto (IDProduto, IDServico, IDMaterial, Valor)
 VALUES (SEQ_Produto.nextval, 2, 3, 3);

-- Pedido
INSERT INTO Pedido (IDPedido, IDCliente, DataInclusao, DataEntrega, Valor, Situacao)
 VALUES (SEQ_Pedido.nextval, 1, TO_DATE('22/11/2015', 'dd/mm/yyyy'), TO_DATE('25/11/2015', 'dd/mm/yyyy'), 10, '0');

-- Item
INSERT INTO Item (IDItem, IDPedido, IDProduto, Peso, ValorUnitario, ValorDesconto, ValorTotal, Situacao)
 VALUES (SEQ_Item.nextval, 1, 1, 2, 5, 0, 10, '0');

COMMIT;
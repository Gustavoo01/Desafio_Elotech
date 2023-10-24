# Desafio técnico Elotech / API Rest utilizando Spring Boot e Java 
## API Rest para cadastro de pessoas com contatos

## Preview:

<img src="/assets/front.gif">

Projeto criado para o desafio técnico do processo seletivo da Elotech.
O projeto consiste em uma API Rest para o cadastro de pessoa + contato.
Também foi implementado um front em Angular para consumir a API.
Tanto a API quanto o Front foram hospedados para facilitar o acesso.

## Link para front: https://gustavoo01.github.io/front-pessoas/
## Link para API: https://api-elotech.up.railway.app/

### Como utilizar os endpoints:

#### Buscar uma única pessoa (GET):
	Produção:
		https://api-elotech.up.railway.app/pessoas/id_da_pessoa_que_deseja_buscar

	Homologação:
		http://localhost:8080/pessoas/id_da_pessoa_que_deseja_buscar
	

#### Buscar todas as pessoas (GET):
	Produção:
		https://api-elotech.up.railway.app/pessoas

	Homologação:
		http://localhost:8080/pessoas

#### Cadastrar pessoa (POST):
	Produção:
		https://api-elotech.up.railway.app/pessoas

	Homologação:
		http://localhost:8080/pessoas

##### Será necessário enviar um json com a seguinte estrutura:

```
{
    "nome": "John",
    "cpf": "664.819.980-69",
    "dataNascimento": "1990-10-11",
    "contatos": [
        {
            "nome": "telefone",
            "telefone": "99887766",
            "email": "teste@email.com"
        }
    ]
}
```
#####	Obs.: 
	Todos os campos (nome, cpf, dataNascimento, nome do contato, telefone do contato e email do contato), devem ser preenchidos.
	O campo CPF deve ser preenchido com um CPF válido.
	O campo dataNascimento não deve conter uma data posterior a atual.
	O Cliente deve possuir ao menos um contato.
	O campo email do contato deve ser preenchido com um e-mail válido.

#### Atualizar pessoa (PUT)
	Produção:
		https://api-elotech.up.railway.app/pessoas/id_da_pessoa_que_deseja_atualizar

	Homologação:
		http://localhost:8080/pessoas/id_da_pessoa_que_deseja_atualizar

##### Será necessário enviar um json com os campos e dados que deseja alterar, segue exemplo:

```
{
    "nome": "John teste update",
    "cpf": "664.819.980-69",
    "dataNascimento": "1980-10-11",
    "contatos": [
        {
            "nome": "telefone",
            "telefone": "99887766",
            "email": "teste@email.com"
        }
    ]
}
```
#### Remover pessoa (DELETE)
	Produção:
		https://api-elotech.up.railway.app/pessoas/id_da_pessoa_que_remover

	Homologação:
		http://localhost:8080/pessoas/id_da_pessoa_que_deseja_remover
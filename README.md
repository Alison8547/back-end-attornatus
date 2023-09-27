# Back End - Attornatus
**Java version 17**

---

* **Objetivo**

API para gerenciar Pessoas com seus endereços.

---

* **Preparando o ambiente**

É só rodar a aplicação, tudo está no banco em memória h2 no link http://localhost:8080/h2-console

---


### Endpoints

Swagger

http://localhost:8080/swagger-ui/index.html#/

---

Postman

* **POST**<br />
Criar uma pessoa http://localhost:8080/create-pessoa <br /> O pattern da data no resquest é dd/MM/yyyy
* Exemplo payload
```
{
    "nome": "Maria",
    "dataNascimento": "11/05/1998"
}
```

---

* **PUT**<br />
  Editar uma pessoa http://localhost:8080/edit-pessoa/{idPessoa} <br />
* Exemplo payload
```
{
    "nome": "Alice",
    "dataNascimento": "11/05/2006"
}
```
---


* **GET**
<br />Consultar uma Pessoa http://localhost:8080/consult-pessoa/{idPessoa} <br />

Exemplo resposta
```
{
    "id": 1,
    "nome": "Alice",
    "dataNascimento": "2006-05-11"
}
```
---

* **GET**
<br />Listar Pessoas http://localhost:8080/list-pessoas <br />

Exemplo resposta
```
[
    {
        "id": 1,
        "nome": "Mario",
        "dataNascimento": "1996-02-10"
    }
]
```

---
* **POST**<br />
  Criar Endereco para uma Pessoa http://localhost:8080/create-endereco/{idPessoa} <br /> 
* Exemplo payload
```
{
    "logradouro": "Rua do sol",
    "cep": "1423112-2",
    "numero": "134",
    "cidade": "Olinda"
}
```
---
* **GET**
  <br /> Listar Endereços da Pessoa http://localhost:8080/list-pessoa-enderecos/{idPessoa} <br />

Exemplo resposta
```
{
    "id": 1,
    "nome": "Maria",
    "dataNascimento": "1998-05-11",
    "enderecoList": [
        {
            "id": 1,
            "logradouro": "Rua do sol",
            "cep": "1423112-2",
            "numero": "134",
            "cidade": "Olinda",
            "principal": false
        }
    ]
}
```
---

* **PUT**<br />
  Informar qual endereço o seu endereço principal http://localhost:8080/edit-principal-endereco/{idEndereco} <br />
* Exemplo payload
```
{
    "principal": "sim"

}
```






















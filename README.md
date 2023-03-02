# tour-beck

## Endspoints

- [Cadastro de viagem](#cadastro-de-viagens)
- [Detalhes Viagem](#detalhes-viagem)
- [Apagar viagem](#deletar-viagem)
- Editar Viagem
- Mostrar todas viagens

### Cadastro de viagens

`POST` tourbeck/api/v1/viagem

**Exemplo de Entrada**

````json
{
    "id" : 1,
    "destino": 'florianopolis',
    "agencia": 'Latam',
    "dia_ida": '2023-03-06',
    "dia_volta": '2023-03-13',
    "categoria": 'Negocios',
    "itens":{
        "cueca": 5,
        "guarda-chuva" : 1,
        "calça": 3,
        "camisa": 6
    }
}
````

**Campos da Requisição**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|destino  |sim          |texto|O destino deve ser um país valido
|agencia|sim|texto| A agencia de viagens que proporcionará o voou
|dia_ida|sim|data| O dia da ida deve ser menor que o dia da volta
|dia_volta|sim|data| O dia da volta deve ser maior do que o da ida
|categoria|sim|texto| O objetivo da viagem(ex: trabalho, diversão)
|itens|não|objeto| itens cadastrados pelo usuario, que ele levará para a viagem em questão

**Códigos da Resposta**

|código|descrição
|-|-
201 | a viagem foi cadastrada com sucesso
400 | os dados enviados são inválidos

---

### Detalhes viagem

`GET` tourbeck/api/v1/viagem/{id}

**Exemplo de Resposta**

````js
{
    "destino": 'florianopolis',
    "agencia": 'Latam',
    "dia_ida": '2023-03-06',
    "dia_volta": '2023-03-13',
    "categoria": 'Negocios',
    "itens":{
        "cueca": 5,
        "guarda-chuva" : 1,
        "calça": 3,
        "camisa": 6
    },
    "Condições_Climaticas":{
        "temperatura_atual": 21,
        "temperatura_max":28,
        "temperatura_min": 18,
        "condicao": 'ensolarado'
    }
}
````
|código|descrição
|-|-
200 | A viagem foi retornada com sucesso
404 | Viagem não encontrada

---

### Deletar Viagem
`DELETE` tourbeck/api/v1/viagem/{id}

|código|descrição
|-|-
200 | A viagem foi deletada com sucesso
204 | A viagem não existe-
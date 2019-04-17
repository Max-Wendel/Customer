# Aplicação
- Arquitetura de Microserviço simples de cadastro de usuário e envio de email.

## Serviços

### Customer
- Serviço responsável pelo CRUD de `Customers`.

### Customer Notification
- Serviço responsável pelo envio de email para os `Customers`.

### Rabbitmq Server
- Servidor do [Rabbitmq](https://www.rabbitmq.com/), _message broker_ que gerencia as filas de mensagens das aplicações.

### FakeSMTP 
- Provedor _SMTP_ falso. Utilizado para verificar os emails enviados aos `Customers`.

## Funcionamento
- Ao cadastrar um `Customer`, pela a api responsável pelo _CRUD_, é enviado um email de confirmação de cadastro pelo serviço de envio de emails.

## Instalando e rodando a aplicação
- Após baixar a aplicação (ou clonar), siga os passos abaixos.
- Instale o servidor `Rabbitmq` em sua máquina e execute via terminal com acesso `sudo`.
```sh
$ sudo rabbitmq-server
```
- Em seguida execute o `FakeSMPT` com o seguinte comando:
```sh
$ java -jar fakeSMTP-2.0.jar
```
- Finalmente, após os passos anteriores, execute cada um dos serviços (`Customer` e `Customer Notification`) com o comando:
```sh
$ mvn clean install spring-boot:run
```
- Acesse `http://localhost:8080/` e verá a aplicação em funcionamento.

## Testando a aplicação 
- Listar todos os `Customers`
```
http://localhost:8080/customers
```
- Listando os `Customers` executando um `paging` e um `sort`.

```
http://localhost:8080/customers?size=2&page=1&sort=name
```

- Pesquisando um `Customers`
```
http://localhost:8080/customers/{id}
```
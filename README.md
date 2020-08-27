# Configuração do Fn Project, Configuração do OCI Registry, Build da função, Deploy da função e Exemplo de Invoke.


Após a instalação do fn project, podemos executá-lo da seguinte forma:

```
fn start
```

Para validar se o fn está rodando podemos executar o seguinte comando:

```
docker ps
```

## Configurando Fn context

Vamos configurar um registro apropriado para armazenar nossas imagens que servirão como base para rodar no docker.

Para validar os contexts, podemos executar:

```
fn list context;
````

```
fn create context demo --provider oracle
```

```
fn use context demo
```

```
fn update context oracle.profile DEFAULT
```
**Nesse cenário estamos utilizando o mesmo profile utilizado no OCI CLI**

```
fn update context oracle.compartment-id <compartment-ocid>
```

```
fn update context api-url https://functions.sa-saopaulo-1.oci.oraclecloud.com
```
```
fn update context registry sa-saopaulo-1.ocir.io/oraclemetodista/leonardo-demo
```

Validando se a configuração do context está correta, podemos executar a listagem de apps.

```
fn list apps
```

Podemos validar as configurações no diretório ~/.fn/contexts/ em arquivos .yaml.

## Build da função

```
fn build -v
```

## Deploy da função 

```
fn deploy -v --app <aplicacao-oracle>
```

## Invoke

```
echo -n <action> | fn invoke <aplicacao-oracle> <function> 
```

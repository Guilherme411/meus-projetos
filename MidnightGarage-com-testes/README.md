# Midnight Garage — estrutura organizada

Projeto reorganizado seguindo a arquitetura em camadas do projeto LojaCarro:

- `controllers`: endpoints REST.
- `model`: modelos `Marca`, `Carro`, `Usuario` e `Log`.
- `repository`: leitura e gravação dos arquivos TXT.
- `services`: regras de negócio e CRUD.
- `exception`: tratamento padronizado de erros.
- `data`: persistência local em TXT.

## Requisitos
- JDK 17 ou superior.
- Não usa MySQL nem outro banco de dados: os dados ficam em `data/*.txt`.

## Executar no Windows
Abra o terminal na pasta do projeto e execute:

```powershell
.\mvnw.cmd spring-boot:run
```

A API inicia em `http://localhost:8080`.

Se o Maven Wrapper não puder baixar o Maven por falta de internet, conecte-se à internet na primeira execução ou use Maven instalado.

## Endpoints principais

### Marcas
- `GET /api/marcas`
- `GET /api/marcas/{id}`
- `POST /api/marcas`
- `PUT /api/marcas/{id}`
- `DELETE /api/marcas/{id}`

Exemplo de JSON para criar marca:

```json
{"nome":"Honda"}
```

### Carros
- `GET /api/carros`
- `GET /api/carros/{id}`
- `GET /api/carros/seminovos`
- `POST /api/carros`
- `PUT /api/carros/{id}`
- `DELETE /api/carros/{id}`

Exemplo de JSON para criar carro:

```json
{
  "marca": "Honda",
  "modelo": "Civic",
  "cor": "Prata",
  "preco": 150000,
  "ano": 2024,
  "seminovo": false
}
```

A marca deve ser cadastrada antes do carro. A API recusa excluir uma marca que ainda tenha carros vinculados. Ao renomear uma marca, os carros associados são atualizados.

### Usuários e logs
- `GET /api/usuarios`, `POST /api/usuarios`, `GET /api/usuarios/{id}`, `PUT /api/usuarios/{id}`, `DELETE /api/usuarios/{id}`
- `GET /api/logs`

## Arquivos de dados
O ZIP já vem com as seis marcas e os 66 modelos do catálogo original de console migrados para `data/marcas.txt` e `data/carros.txt`. Os novos cadastros continuam sendo dinâmicos.

A aplicação cria automaticamente, se não existirem:
- `data/marcas.txt`
- `data/carros.txt`
- `data/usuarios.txt`
- `data/logs.txt`

Não apague os arquivos TXT se quiser preservar os registros.

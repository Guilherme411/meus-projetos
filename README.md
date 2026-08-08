# 🌙 Midnight Garage

Sistema desenvolvido em Java que simula uma loja de veículos, permitindo ao usuário navegar entre marcas, visualizar carros cadastrados, anunciar novos veículos e consultar suas informações.

---

## 📚 Visão Geral

Este repositório reúne o projeto desenvolvido para a disciplina de **Análise e Projeto de Sistemas Web**.

O objetivo é aplicar conceitos de **Programação Orientada a Objetos (POO)** e **padrões de projeto GoF**, promovendo um código mais organizado, reutilizável e de fácil manutenção.

---

## 🎯 Objetivo

Desenvolver uma aplicação em Java aplicando conceitos de:

- Programação Orientada a Objetos (POO)
- Organização de classes e métodos
- Padrões de projeto GoF
- Estruturação de sistemas em console
- Boas práticas de desenvolvimento

---

## ⚙️ Funcionalidades

O sistema permite:

- Navegar pelo menu principal da loja;
- Visualizar marcas de veículos disponíveis;
- Selecionar uma marca e listar seus modelos;
- Consultar informações de cada veículo;
- Anunciar novos veículos (nome, cor e preço);
- Notificar automaticamente clientes cadastrados sobre novos anúncios.

### 📌 Informações dos veículos:
- Nome
- Cor
- Preço

---

## 🏛️ Padrões de Projeto Utilizados (GoF)

### ✅ Factory Method
Responsável pela criação de objetos `Carro` através da classe `FabricaCarros`, evitando duplicação de código e facilitando manutenção.

### ✅ Facade
A classe `LojaFacade` centraliza as operações principais do sistema, simplificando a comunicação entre as funcionalidades da loja.

### ✅ Observer
A classe `CentralAnuncios` notifica automaticamente os clientes cadastrados quando um novo veículo é anunciado.

---

## 🛠️ Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Padrões de Projeto GoF
- Git
- GitHub

---

## 📂 Estrutura do Projeto

O projeto foi organizado em classes com responsabilidades bem definidas, facilitando manutenção e escalabilidade.

---

## 🚀 Como executar

1. Clone este repositório;
git clone https://github.com/software-engineering-labs-ifrn/2026-1-Guilherme.git

2. Abra o projeto em uma IDE Java (NetBeans, IntelliJ IDEA ou Eclipse)

javac *.java

3. Execute a classe `Main`;

java Main

4. Navegue pelos menus e utilize as funcionalidades disponíveis.

---

## 📖 Aprendizados

Durante o desenvolvimento deste projeto foram praticados conceitos como:

- Classes e Objetos
- Encapsulamento
- Organização do código
- Separação de responsabilidades entre as classes
- Estruturas de decisão (switch)
- Menus interativos
- Entrada de dados utilizando Scanner
- Aplicação de padrões de projeto GoF

---

## 🔮 Próximas melhorias

Algumas funcionalidades que poderão ser adicionadas futuramente:

- Persistência de dados com banco de dados
- Cadastro permanente de veículos
- Pesquisa por nome ou marca
- Sistema de compra e venda
- Interface gráfica (GUI)
- Cadastro de usuários

---

## 👨‍💻 Autor

Projeto desenvolvido por **Guilherme** durante a disciplina de **Análise e Projeto de Sistemas Web**.
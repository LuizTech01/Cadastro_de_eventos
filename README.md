# Sistema de Cadastro e Notificação de Eventos

## Descrição

Este projeto implementa um sistema em Java para cadastro, listagem, alteração e gerenciamento de participação em eventos. O sistema é orientado a objetos e desenvolvido em console.

## Funcionalidades

- Cadastro de eventos com os seguintes atributos:
  - Nome
  - Endereço
  - Categoria (ex.: festas, esportes, shows)
  - Horário (apenas hora do dia, HH:mm)
  - Descrição
- Alteração de eventos cadastrados.
- Listagem de eventos com:
  - Status do evento: já ocorreu, ocorrendo agora ou futuro
  - Indicação de presença do usuário: "Presença confirmada!" ou "Sem confirmação."
- Confirmação e cancelamento de participação em eventos.
- Persistência das informações em arquivos de texto:
  - `evento.data` → eventos cadastrados
  - `participacao.data` → participações confirmadas

## Estrutura do Projeto

Pacotes principais:

- `menu.cadastroDeEvento` → classe `cadastrarEvento`
- `menu.listarEventos` → classe `listarEventos`
- `menu.alterarEvento` → classe `alterarEvento`
- `menu.participarEvento` → classe `participarEvento`
- `menu` → menu interativo

## Como Executar

1. Abra o projeto em sua IDE Java preferida.
2. Compile e execute a classe `sistema.java`.
3. Utilize o menu para cadastrar, listar, alterar eventos e gerenciar participação.


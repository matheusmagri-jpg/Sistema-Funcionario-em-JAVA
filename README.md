# Sistema de Gestão de Funcionários

**Autor:** Matheus Magri  
**Linguagem:** Java  
**Tipo:** Projeto acadêmico de console

## Sobre o projeto

O Sistema de Gestão de Funcionários permite cadastrar e consultar funcionários de um departamento, acompanhar a folha salarial e executar ações individuais, como reajustar salário ou registrar o desligamento de um funcionário.

O projeto foi organizado em classes para separar as responsabilidades e facilitar o aprendizado de programação orientada a objetos.

## Funcionalidades

- Cadastro de funcionários com nome, CPF, cargo e salário.
- Validação de campos de texto obrigatórios e de valores numéricos.
- Limite de até 5 funcionários por departamento.
- Listagem dos funcionários cadastrados.
- Consulta da folha salarial considerando somente funcionários ativos.
- Menu individual para reajustar salário, demitir ou consultar dados.
- Resumo do departamento com total cadastrado, ativos, demitidos e folha salarial ativa.
- Exibição de valores monetários no formato brasileiro.

## Tecnologias e conceitos

- Java 17 ou superior.
- Programação orientada a objetos.
- Classes, objetos, encapsulamento, métodos e construtores.
- Listas (`ArrayList`) para manter os funcionários em memória.
- Estruturas de decisão (`if`, `switch`) e repetição (`while`, `do-while`, `for`).
- Tratamento de entradas inválidas com `try/catch`.

## Organização das pastas

```text
SistemaFuncionarios1/
├── src/
│   ├── TesteSistema.java
│   ├── menu/
│   │   ├── CadastroFuncionario.java
│   │   ├── MenuDepartamento.java
│   │   └── MenuFuncionario.java
│   ├── modelo/
│   │   ├── Departamento.java
│   │   └── Funcionario.java
│   └── util/
│       ├── Formatador.java
│       └── LeitorConsole.java
├── nbproject/
├── build.xml
├── manifest.mf
├── .gitignore
└── README.md
```

- **`modelo`**: representa as entidades e regras do sistema.
- **`menu`**: apresenta as opções e coleta os dados para cadastro.
- **`util`**: reúne recursos reutilizáveis para leitura e formatação.
- **`TesteSistema.java`**: inicia a aplicação e coordena os menus.

## Como executar

### Pelo Apache NetBeans

1. Extraia o arquivo ZIP.
2. No NetBeans, selecione **File > Open Project** e escolha a pasta `SistemaFuncionarios1`.
3. Verifique se o projeto está usando JDK 17 ou superior.
4. Execute o projeto (Run Project).

### Pelo terminal

Com o JDK instalado, entre na pasta do projeto e compile os arquivos:

```bash
javac -encoding UTF-8 -d out src/TesteSistema.java src/menu/*.java src/modelo/*.java src/util/*.java
```

Depois execute:

```bash
java -cp out TesteSistema
```

## Observações importantes

- Os dados são mantidos apenas durante a execução. Ao fechar o programa, os cadastros não são salvos em arquivo ou banco de dados.
- O CPF é armazenado como texto; este projeto ainda não realiza validação dos dígitos verificadores nem impede CPFs duplicados.
- O limite de cinco funcionários é uma regra didática definida em `Departamento.CAPACIDADE_MAXIMA`.
- O sistema é um projeto educacional e não deve ser usado como sistema oficial de folha de pagamento.

## Melhorias futuras

- Salvar os dados em arquivo ou banco de dados.
- Validar CPF e impedir cadastros duplicados.
- Permitir editar dados cadastrais e pesquisar por nome ou CPF.
- Criar testes automatizados.
- Desenvolver uma interface gráfica.

---

Desenvolvido por **Matheus Magri** como projeto de estudo em Java.

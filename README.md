# Projeto Java: Operador de Caixa com iText e JFrame

## 👨‍💻 Introdução

Este é um sistema simples de **Operador de Caixa** implementado em **Java**, utilizando as bibliotecas:

- **iText**: Para gerar recibos de vendas em formato PDF.
- **JFrame**: Para a interface gráfica onde o operador de caixa interage com o sistema.

## 🚀 Funcionalidade

O programa permite ao operador de caixa registrar o valor da venda e, ao clicar em "Gerar Recibo", um recibo em PDF é gerado, detalhando a venda realizada.

### 🔧 Dependências

As principais bibliotecas utilizadas no projeto são:

- **iText**: Usada para criar o arquivo PDF com os detalhes da venda.
- **JFrame**: Usada para a construção da interface gráfica onde o operador de caixa insere os dados da venda.

### 🖥️ Interface Gráfica

A interface gráfica foi criada com a classe **JFrame** para que o operador de caixa possa inserir informações como:

- Valor da venda.
- Nome do cliente.

Essas informações são então utilizadas para gerar um recibo de venda em **PDF**.

### 📝 Gerando o Recibo

Após o operador inserir os dados na interface gráfica, o programa usa a biblioteca **iText** para gerar um recibo em PDF, que pode ser impresso ou enviado para o cliente.

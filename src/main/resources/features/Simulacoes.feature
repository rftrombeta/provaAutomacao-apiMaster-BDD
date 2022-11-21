#language: pt
Funcionalidade: Simulacoes

  @Test
  Cenario: Criar uma simulacao
    Dado que possuimos um cpf com restricao
    Quando enviar a requisicao para validacao
    Entao o endpoint deve retornar o status 200 e a mensagem "O CPF numeroCpf tem problema"

  Cenario: Consultar cpf sem restricao
    Dado que possuimos um cpf sem restricao
    Quando enviar a requisicao para validacao
    Entao o endpoint deve retornar o status 204

  Esquema do Cenario: Cenario Generico para consultar cpfs com e sem restricao e um unico step
    Dado que possuimos o cpf <cpf>
    Quando enviar a requisicao para validacao
    Entao o endpoint deve retornar o status <status> e a mensagem de restricao caso haja <mensagem>

    Exemplos:
      | cpf           | status | mensagem                       |
      | "85876554006" | 204    | ""                             |
      | "89014514093" | 204    | ""                             |
      | "39006340090" | 204    | ""                             |
      | "97093236014" | 200    | "O CPF numeroCpf tem problema" |
      | "97093236014" | 200    | "O CPF numeroCpf tem problema" |
      | "97093236014" | 200    | "O CPF numeroCpf tem problema" |
      | "97093236014" | 200    | "O CPF numeroCpf tem problema" |
      | "97093236014" | 200    | "O CPF numeroCpf tem problema" |
      | "97093236014" | 200    | "O CPF numeroCpf tem problema" |
      | "97093236014" | 200    | "O CPF numeroCpf tem problema" |
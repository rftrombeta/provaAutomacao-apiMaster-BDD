#language: pt
Funcionalidade: Consultar Simulacoes

  Cenario: Consultar simulacoes cadastradas
    Quando enviar a requisicao para consultar
    Entao o endpoint deve retornar o statusCode 200 e uma lista com as simulacoes cadastradas

  Cenario: Consultar CPF com simulacao cadastrada
    Dado que possua um CPF com simulacao realizada
    Quando enviar a requisicao para consultar o CPF
    Entao o endpoint deve retornar o statusCode 200 e as informacoes da simulacao

  Cenario: Consultar CPF sem simulacao cadastrada
    Dado que possua um CPF sem simulacao realizada
    Quando enviar a requisicao para consultar o CPF
    Entao o endpoint deve retornar o status 404 e a mensagem "CPF numeroCpf não encontrado"
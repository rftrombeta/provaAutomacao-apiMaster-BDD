#language: pt
Funcionalidade: Criar Simulacoes

  Cenario: Criar uma simulacao
    Dado que possuimos todas as informacoes necessarias para criar uma simulacao
    Quando enviar a requisicao para criacao
    Entao o endpoint deve retornar o statusCode 201

  @test_PEND
  Cenario: Validar uma simulacao com cpf duplicado
    Dado que possuimos um body com um cpf já utilizado para criar uma simulacao
    Quando enviar a requisicao para criacao
    Entao o endpoint deve retornar o statusCode 409 e a mensagem "CPF duplicado"

  Cenario: Validar uma simulacao incorreta
    Dado que possuimos um body com informacoes invalidas para criar uma simulacao
    Quando enviar a requisicao para criacao
    Entao o endpoint deve retornar o statusCode 400 e uma lista com os erros encontrados